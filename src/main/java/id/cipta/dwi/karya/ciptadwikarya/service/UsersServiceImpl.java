package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Roles;
import id.cipta.dwi.karya.ciptadwikarya.domain.Users;
import id.cipta.dwi.karya.ciptadwikarya.repository.RolesRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersServiceImpl implements UsersService{
    
    private static final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);
    
    @Autowired
    private UsersRepository repository;
    
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    @Transactional
    public Users saveUsers(Users users) {
        
        if(users != null){
            Users userValid = repository.save(users);
            logger.info(userValid.toString());
            if(users != null){
                Roles roles = new Roles();
                roles.setRole("ADMIN");
                roles.setIdUser(userValid);
                rolesRepository.save(roles);
            }            
        }        
        return users;        
    }
    
}
