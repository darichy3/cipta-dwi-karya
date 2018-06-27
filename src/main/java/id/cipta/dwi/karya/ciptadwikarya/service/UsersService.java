package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Users;
import java.util.List;
import org.springframework.validation.BindingResult;

public interface UsersService {
    public Users saveUsers(Users users);
    
    public Users updateUsers(Users users);
    
    List<Users> findAll();
    
    Users findOne(Integer idUser);
    
    void deleteUsers(Integer idUser);
    
}
