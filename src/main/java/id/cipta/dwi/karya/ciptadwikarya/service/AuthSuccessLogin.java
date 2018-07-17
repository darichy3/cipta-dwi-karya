package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Users;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthSuccessLogin implements ApplicationListener<AuthenticationSuccessEvent>{

    @Autowired
    private UsersService usersService;
    
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent e) {
        WebContextHolder holder = new WebContextHolder();
        
        String loginName = e.getAuthentication().getName();
        
        Users users = usersService.findByUsername(loginName);
        
        HttpSession session = holder.getSession();
        
        session.setAttribute("loginId", users.getIdUser());
        session.setAttribute("userName", loginName);
    }
    
}