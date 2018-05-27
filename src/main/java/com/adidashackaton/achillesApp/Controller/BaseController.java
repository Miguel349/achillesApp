package com.adidashackaton.achillesApp.Controller;

import com.adidashackaton.achillesApp.Service.UserDataService;
import com.adidashackaton.achillesApp.Service.UserService;
import com.adidashackaton.achillesApp.pojos.User;
import com.adidashackaton.achillesApp.pojos.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BaseController extends Base {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDataService userDataService;

    @GetMapping("/")
    public String hello(HttpServletRequest httpServletRequest) {
        return "index.html";
    }
}
