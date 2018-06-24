package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Inventory;
import id.cipta.dwi.karya.ciptadwikarya.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryServiceImpl implements InventoryService{
    
    private static final Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);
    
    @Autowired
    private InventoryRepository repository;
   
    @Override
    @Transactional
    public Inventory saveInventory(Inventory inventory) {
        
        if(inventory != null){
            Inventory inventoryValid = repository.save(inventory);
            logger.info(inventoryValid.toString());
                   
        }        
        return inventory;        
    }
    
}
