package com.adidashackaton.achillesApp.Controller;

import com.adidashackaton.achillesApp.Service.UserDataService;
import com.adidashackaton.achillesApp.Service.UserService;
import com.adidashackaton.achillesApp.pojos.User;
import com.adidashackaton.achillesApp.pojos.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class BaseRestController extends Base{

    @Autowired
    private UserService userService;

    @Autowired
    private UserDataService userDataService;

    @PostMapping("/achilles/getGlobalStats")
    public String recordData(HttpServletRequest httpServletRequest) {
        return "";
    }

    @PostMapping("/achilles/recordData")
    public Boolean recordData(String foot, Double sensor1, Double sensor2, Double sensor3, Double sensor4, Double calories, Double meters, HttpServletRequest httpServletRequest){
        Integer userId = getLoggedUserId(httpServletRequest);
        if (userId != null) {
            User user = userService.getUser(userId);
            if(user==null){
                return false;
            }
            UserData userData = userDataService.saveNewUserData(user, foot, sensor1, sensor2, sensor3, sensor4, calories, meters);
            String sport = "football";

            if (sport.equals("football")) {
                if (sensor1 > 1 && sensor2 > 1 && sensor3 > 1) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    @PostMapping("/achilles/endSession")
    public List<UserData> endSession(int id){
        return null;
    }
    @PostMapping("/achilles/register")
    public Boolean register (Integer id, String gender, Integer edad) {
        if(id!=null && gender!=null && edad !=null){
            userService.saveNewUser(id,edad,gender);
            return true;
        }
        return false;
    }

    @PostMapping("/achilles/login")
    public Boolean login( Integer id,HttpServletRequest httpServletRequest){
        if(id!=null){
            setLoggedUserId(httpServletRequest,id);
        }
        return true;
    }

    @PostMapping("/achilles/saveSport")
    public Boolean selectSport(String sport){
        //Guardar el deporte en sesión
        return true;
    }
    @PostMapping("/achilles/saveTraining")
    public Boolean verCalentamiento(Boolean verCalentamiento){
        //Guardar si vas a hacer el calentamiento
        return true;
    }

    @PostMapping("/achilles/getStats")
    public String getStats(Boolean verCalentamiento){
        return "";
    }

    @PostMapping("/achilles/initSession")
    public String initSesion(HttpServletRequest httpServletRequest){
        Integer userId=getLoggedUserId(httpServletRequest);
        if(userId!=null){

        }
        return "";
    }
}
