package com.owoez.user.controller;

import com.owoez.user.entity.User;
import com.owoez.user.service.UserService;
import com.owoez.user.valueobject.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping("/")
  public User saveUser(@RequestBody User user){
    log.info("Inside saveUser method of User Controller");
    return userService.saveUser(user);
  }

  @GetMapping("/{id}")
  public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
    return userService.getUserWithDepartment(userId);
  }
}
