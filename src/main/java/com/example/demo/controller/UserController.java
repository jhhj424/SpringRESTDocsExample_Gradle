package com.example.demo.controller;

import com.example.demo.model.Header;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public Header<User> create(@RequestBody User requestUser) {
        User savedUser = userService.create(requestUser);
        if (savedUser != null) {
            return Header.OK(savedUser);
        }
        return Header.ERROR();
    }
}
