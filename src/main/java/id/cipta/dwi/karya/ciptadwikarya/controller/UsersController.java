package id.cipta.dwi.karya.ciptadwikarya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UsersController {
    
    @RequestMapping("/login")
    public String LoginAction(){
        
        return "login";
        
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String AddAction(){
        
        return "addUsers";
        
    }
    
}
