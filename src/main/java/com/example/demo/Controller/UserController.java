package com.example.demo.Controller;

import com.CareBook.MediSched.Dto.UserDto;
import com.CareBook.MediSched.Model.User;
import com.CareBook.MediSched.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")

public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto){
        var authenticatedUser = userService.authenticateUser(userDto);
        return ResponseEntity.ok(authenticatedUser);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        return ResponseEntity.ok(userService.sendResetPasswordEmail(email));
    }
}
