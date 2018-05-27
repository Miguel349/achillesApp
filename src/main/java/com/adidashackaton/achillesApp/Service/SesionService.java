package com.adidashackaton.achillesApp.Service;

import com.adidashackaton.achillesApp.Persistance.SesionRepository;
import com.adidashackaton.achillesApp.Persistance.UserRepository;
import com.adidashackaton.achillesApp.pojos.Sesion;
import com.adidashackaton.achillesApp.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesionService {

    @Autowired
    private SesionRepository sesionRepository;

    public Sesion getSesions(User user){
        Sesion sesion=sesionRepository.findByUser(user);
        return sesion;
    }

    public Sesion endSesion(int calories, int meters,
                               double leftFootSensor1,double leftFootSensor2,
                               double leftFootSensor3, double leftFootSensor4,
                               double rightFootSensor1,double rightFootSensor2,
                                double rightFootSensor3,double rightFootSensor4,
                                User user){
        Sesion sesion=new Sesion();
        sesion.setCalories(calories);
        sesion.setMeters(meters);
        sesion.setLeftSensor1(leftFootSensor1);
        sesion.setLeftSensor2(leftFootSensor2);
        sesion.setLeftSensor3(leftFootSensor3);
        sesion.setLeftSensor4(leftFootSensor4);
        sesion.setRightSensor1(rightFootSensor1);
        sesion.setRightSensor2(rightFootSensor2);
        sesion.setRightSensor3(rightFootSensor3);
        sesion.setRightSensor4(rightFootSensor4);
        return sesionRepository.save(sesion);
    }
    public Sesion createSesion(User user){
        Sesion sesion=new Sesion();
        sesion.setCalories(0);
        sesion.setMeters(0);
        sesion.setLeftSensor1(0);
        sesion.setLeftSensor2(0);
        sesion.setLeftSensor3(0);
        sesion.setLeftSensor4(0);
        sesion.setRightSensor1(0);
        sesion.setRightSensor2(0);
        sesion.setRightSensor3(0);
        sesion.setRightSensor4(0);
        sesion.setUser(user);
        return sesionRepository.save(sesion);
    }
}
