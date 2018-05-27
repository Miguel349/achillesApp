package com.adidashackaton.achillesApp.Service;

import com.adidashackaton.achillesApp.Persistance.UserDataRepository;
import com.adidashackaton.achillesApp.pojos.User;
import com.adidashackaton.achillesApp.pojos.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

    public UserData saveNewUserData(User user, String foot, double sensor1, double sensor2, double sensor3, double sensor4, double calories, double meters){
        UserData userData=new UserData();
        userData.setFoot(foot);
        userData.setSensor1(sensor1);
        userData.setSensor2(sensor2);
        userData.setSensor3(sensor3);
        userData.setSensor4(sensor4);
        userData.setUser(user);
        userData.setMeters(meters);
        return userDataRepository.save(userData);
    }
}
