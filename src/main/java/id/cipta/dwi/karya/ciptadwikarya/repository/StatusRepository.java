package id.cipta.dwi.karya.ciptadwikarya.repository;

import id.cipta.dwi.karya.ciptadwikarya.domain.Status;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
    List<Status> findByName(String name);
    
    Status findByIdStatus(Integer idStatus);
}
