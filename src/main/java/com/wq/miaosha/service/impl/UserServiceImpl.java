package com.wq.miaosha.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.wq.miaosha.entity.User;
import com.wq.miaosha.exception.GlobalException;
import com.wq.miaosha.mapper.UserMapper;
import com.wq.miaosha.redis.RedisService;
import com.wq.miaosha.redis.UserKey;
import com.wq.miaosha.result.CodeMsg;
import com.wq.miaosha.service.UserService;
import com.wq.miaosha.util.MD5Util;
import com.wq.miaosha.util.UUIDUtil;
import com.wq.miaosha.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl implements UserService {
    public static final String COOKI_NAME_TOKEN = "token";

    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisService redisService;

    @Override
    public User getUserById(Long id) {
        //取缓存
       User user = redisService.get(UserKey.getById, ""+id, User.class);
        if(user != null) {
            return user;
        }
        //取数据库
        user = userMapper.selectById(id);
        if(user != null) {
            redisService.set(UserKey.getById, ""+id, user);
        }
        return user;
    }

    public boolean updatePassword(String token, long id, String formPass) {
        //取user
        User user = getUserById(id);
        if(user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //更新数据库
        User toBeUpdate = new User();
        toBeUpdate.setId(id);
        toBeUpdate.setPassword(MD5Util.formPassToDBPass(formPass, user.getSalt()));
        userMapper.updateUserById(toBeUpdate);
        //处理缓存
        redisService.delete(UserKey.getById, ""+id);
        user.setPassword(toBeUpdate.getPassword());
        redisService.set(UserKey.token, token, user);
        return true;
    }

    public boolean login(HttpServletResponse response, LoginVo loginVo) {
        if(loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        //判断手机号是否存在
        User user = getUserById(Long.parseLong(mobile));
        if(user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);
        if(!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
         //生成cookie
        String token	 = UUIDUtil.uuid();
        addCookie(response, token, user);
        return true;
    }
    private void addCookie(HttpServletResponse response, String token, User user) {
        redisService.set(UserKey.token, token, user);
        Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
        cookie.setMaxAge(UserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }


    public User getByToken(HttpServletResponse response, String token) {
        if(StringUtils.isEmpty(token)) {
            return null;
        }
        User user = redisService.get(UserKey.token, token, User.class);
        //延长有效期
        if(user != null) {
            addCookie(response, token, user);
        }
        return user;
    }

}
