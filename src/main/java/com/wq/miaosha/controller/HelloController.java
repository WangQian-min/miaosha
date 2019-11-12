package com.wq.miaosha.controller;

import com.wq.miaosha.entity.User;
import com.wq.miaosha.redis.RedisService;
import com.wq.miaosha.redis.UserKey;
import com.wq.miaosha.result.Result;
import com.wq.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Autowired
    UserService userService;
    @Autowired
    RedisService redisService;









}
