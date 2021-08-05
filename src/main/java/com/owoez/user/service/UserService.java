package com.owoez.user.service;


import com.owoez.user.entity.User;
import com.owoez.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User saveUser(User user) {
    log.info("Inside saveUser of user service");
    return userRepository.save(user);
  }
}
