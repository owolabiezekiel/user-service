package com.owoez.user.service;


import com.owoez.user.entity.User;
import com.owoez.user.repository.UserRepository;
import com.owoez.user.valueobject.Department;
import com.owoez.user.valueobject.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RestTemplate restTemplate;

  public User saveUser(User user) {
    log.info("Inside saveUser of user service");
    return userRepository.save(user);
  }

  public ResponseTemplateVO getUserWithDepartment(Long userId) {
    log.info("Inside getUserWithDepartment of user service");
    ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
    User user = userRepository.findByUserId(userId);

    Department department = restTemplate
        .getForObject("http://localhost:9001/departments/" + user.getDepartmentId(), Department.class);
    responseTemplateVO.setUser(user);
    responseTemplateVO.setDepartment(department);

    return responseTemplateVO;
  }
}
