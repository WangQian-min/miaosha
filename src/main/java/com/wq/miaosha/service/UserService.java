package com.wq.miaosha.service;


import com.wq.miaosha.entity.User;
import com.wq.miaosha.vo.LoginVo;

import javax.servlet.http.HttpServletResponse;

public interface UserService {
    public static final String COOKI_NAME_TOKEN = "token";
    User getUserById(Long id);
    boolean login(HttpServletResponse response, LoginVo loginVo);
    public User  getByToken(HttpServletResponse response, String token);
}
