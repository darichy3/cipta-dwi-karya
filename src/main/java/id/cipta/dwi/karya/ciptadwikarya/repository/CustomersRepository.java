package id.cipta.dwi.karya.ciptadwikarya.repository;

import id.cipta.dwi.karya.ciptadwikarya.domain.Customers;
import id.cipta.dwi.karya.ciptadwikarya.domain.Users;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    List<Customers> findByName(String name);
    
    Customers findByIdCustomer(Integer idCustomer);
    
    List<Customers> findByCreatedDateBetween(Date tglAwal, Date tglAkhir);
    
}
