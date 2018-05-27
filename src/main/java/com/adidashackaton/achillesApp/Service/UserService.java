package com.adidashackaton.achillesApp.Service;

import com.adidashackaton.achillesApp.Persistance.UserRepository;
import com.adidashackaton.achillesApp.pojos.User;
import com.adidashackaton.achillesApp.pojos.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveNewUser(Integer id, int age, String gender){
        User user = new User();
        user.setId(id);
        user.setAge(age);
        user.setGender(gender);
        return userRepository.save(user);
    }

    public User getUser(Integer id){
        User user=userRepository.findById(id);
        return user;
    }
    public User findByName(String name){
      User user=userRepository.findByName(name);
      return user;
    }
}
