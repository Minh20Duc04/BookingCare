package com.example.demo.Service;


import com.example.demo.Dto.UserDto;
import com.example.demo.Model.User;

import java.util.Map;

public interface UserService {
    User register(UserDto userDto);

    Map<String, Object> authenticateUser(UserDto userDto);


    String sendResetPasswordEmail(String email);
}
