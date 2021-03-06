package id.cipta.dwi.karya.ciptadwikarya.repository;

import id.cipta.dwi.karya.ciptadwikarya.domain.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
    Users findByUsername(String username);
    Users findByName(String name);
    
    Users findByIdUser(Integer idUser);
}