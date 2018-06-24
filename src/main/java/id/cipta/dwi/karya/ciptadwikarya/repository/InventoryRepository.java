package id.cipta.dwi.karya.ciptadwikarya.repository;

import id.cipta.dwi.karya.ciptadwikarya.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
    
}