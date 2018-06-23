package id.cipta.dwi.karya.ciptadwikarya.controller;

import id.cipta.dwi.karya.ciptadwikarya.domain.Roles;
import id.cipta.dwi.karya.ciptadwikarya.domain.Users;
import id.cipta.dwi.karya.ciptadwikarya.form.FormUsers;
import id.cipta.dwi.karya.ciptadwikarya.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UsersController {
    
    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
    
    @Autowired
    private UsersService usersService;
    
    @RequestMapping("/login")
    public String LoginAction(){
        
        return "login";
        
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String GetAddAction(FormUsers formUsers){
        
        return "addUsers";        
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String PostAddAction(FormUsers formUsers){
        
        Users users = new Users();
        users.setUsername(formUsers.getUsername());
        users.setPassword(formUsers.getPassword());
        users.setName(formUsers.getName());
        users.setEnable(1);
        
        usersService.saveUsers(users);
        
        logger.info(formUsers.toString());
        
        return "redirect:/user/add";        
    }
    
}
