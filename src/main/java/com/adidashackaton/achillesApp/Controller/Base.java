package com.adidashackaton.achillesApp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Base {


    public Integer getLoggedUserId(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession(true);
        Integer userId=(int)session.getAttribute("user");
        return userId;
    }

    public void setLoggedUserId(HttpServletRequest httpServletRequest, int id){
        HttpSession session = httpServletRequest.getSession(true);
        session.setAttribute("user", id);
    }
}

