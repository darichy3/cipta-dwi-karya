package id.cipta.dwi.karya.ciptadwikarya.controller;

import id.cipta.dwi.karya.ciptadwikarya.domain.Roles;
import id.cipta.dwi.karya.ciptadwikarya.domain.Users;
import id.cipta.dwi.karya.ciptadwikarya.form.FormUsers;
import id.cipta.dwi.karya.ciptadwikarya.repository.UsersRepository;
import id.cipta.dwi.karya.ciptadwikarya.service.UsersService;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UsersController {
    
    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
    
    @Autowired
    private UsersService usersService;
    
    @Autowired
    private UsersRepository usersRepository; 
    
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
        
        return "redirect:/user/menu";        
    }
    
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String GetMenuAction(Model model){
        
        model.addAttribute("users", usersRepository.findAll());
        
        return "menuUsers";        
    }
    
    @RequestMapping(value={"/edit","/edit/{idUser}"}, method = RequestMethod.GET)
    public String GetEditAction(Model model, @PathVariable(required = false, name = "idUser") Integer idUser) {
        if (null != idUser) {
                model.addAttribute("users", usersService.findOne(idUser));
        } else {
            model.addAttribute("users", new Users());
        }
        return "editUsers";
    }
    
    @RequestMapping(value={"/edit","/edit/{idUser}"}, method = RequestMethod.POST)
    public String PostEditAction(Model model, @Valid @ModelAttribute("users") Users users, FormUsers formUsers) {
        
        users.setUsername(formUsers.getUsername());
        users.setPassword(formUsers.getPassword());
        users.setName(formUsers.getName());
        
        usersService.updateUsers(users);
        logger.info(formUsers.toString());
        model.addAttribute("users", usersService.findAll());
        return "menuUsers";
    }

    @RequestMapping(value="/delete/{idUser}", method = RequestMethod.GET)
    public String GetDeleteAction(Model model, @PathVariable(required = true, name = "idUser") Integer idUser) {
        usersService.deleteUsers(idUser);
        model.addAttribute("users", usersService.findAll());
        return "menuUsers";
    }
    
}
