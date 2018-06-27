package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Roles;
import id.cipta.dwi.karya.ciptadwikarya.domain.Users;
import id.cipta.dwi.karya.ciptadwikarya.repository.RolesRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.UsersRepository;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

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
                roles.setRole("ROLE_ADMIN");
                roles.setIdUser(userValid);
                rolesRepository.save(roles);
            }            
        }        
        return users;        
    }

    @Override
    public List<Users> findAll() {
        return repository.findAll();
    }

    @Override
    public Users findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public void deleteUsers(Integer id) {
        repository.delete(id);
    }
    
    @Override
    @Transactional
    public Users updateUsers(@Valid @ModelAttribute("users")Users users) {
        
        if(users != null){
            Users userDb = repository.findByIdUser(users.getIdUser());
            userDb.setUsername(users.getUsername());
            userDb.setPassword(users.getPassword());
            userDb.setName(users.getName());
            userDb.setEnable(1);
            repository.save(userDb);
            logger.info(userDb.toString());        
        }        
        return users;        
    }
    
}
