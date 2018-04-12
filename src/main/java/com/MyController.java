package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;


@RestController
public class MyController {
    @Autowired
    AuthSuccessHandler authSuccessHandler;
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        principal.getName();
        return new Greeting("Hello Vegas!");
    }

   /* @RequestMapping(value = "/redirectPage", method = RequestMethod.GET)
    public String getRedirectPage(){
        HttpServletRequest request = ;
        authSuccessHandler.determineTargetUrl(HttpServletRequest request, HttpServletResponse response);
        return "";
    }*/

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public HashMap<String, String> loginMethod(HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        GrantedAuthority grantedAuthority = ((UsernamePasswordAuthenticationToken) principal).getAuthorities().iterator().next();
        HashMap<String, String> map = new HashMap<String, String>();
        if(grantedAuthority.getAuthority().equals("ROLE_USER")){
            map.put("redirectSide","../view/home.html");
            return map;
        }
        else if(grantedAuthority.getAuthority().equals("ROLE_ADMIN")){
            map.put("redirectSide","../view/employee.html");
            return map;
        }
        return map;
    }

    /*@RequestMapping(value = "/home")
    public String cos(){
        return "view/home.html";
    }*/
}
