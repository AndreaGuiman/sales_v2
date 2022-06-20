package com.gad.sales_v2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public User getById(@PathVariable("id") Long id){
        return userService.getById(id);
    }

    @PostMapping
    public UserDTO authenticate(@RequestBody User user){
        return userService.authenticate(user);
    }
}
