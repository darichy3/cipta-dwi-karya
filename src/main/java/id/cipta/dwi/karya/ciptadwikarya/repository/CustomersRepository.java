package id.cipta.dwi.karya.ciptadwikarya.repository;

import id.cipta.dwi.karya.ciptadwikarya.domain.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    
}
