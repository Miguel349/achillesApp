package com.adidashackaton.achillesApp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Base {


    public String getLoggedUserId(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession(true);
        String userId=(String)session.getAttribute("user");
        return userId;
    }

    public void setLoggedUserId(HttpServletRequest httpServletRequest, String id){
        HttpSession session = httpServletRequest.getSession(true);
        session.setAttribute("user", id);
    }
}

