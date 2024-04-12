package com.springboot.blog.service;

import com.springboot.blog.dto.LoginDto;
import com.springboot.blog.dto.RegisterDto;

import java.util.Map;

public interface AuthService {

    String login(LoginDto loginDto);
    Map<String, Object> register(RegisterDto registerDto);
}
