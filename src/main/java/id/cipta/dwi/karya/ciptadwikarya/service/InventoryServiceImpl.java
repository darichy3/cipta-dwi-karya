package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Inventory;
import id.cipta.dwi.karya.ciptadwikarya.repository.InventoryRepository;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

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

    @Override
    public Inventory updateInventory(@Valid @ModelAttribute("inventories") Inventory inventories) {
        logger.info("Result inventory: "+inventories.toString());
        if(inventories != null){
            Inventory inventoryDb = repository.findByIdInventory(inventories.getIdInventory());
            inventoryDb.setName(inventories.getName());
            inventoryDb.setSumIn(inventories.getSumIn());
            inventoryDb.setSumOut(0);
            inventoryDb.setSumEnd(0);
            inventoryDb.setNote(inventories.getNote());
            repository.save(inventoryDb);
            logger.info(inventoryDb.toString());        
        }        
        return inventories;   
    }

    @Override
    public List<Inventory> findAll() {
        return repository.findAll();
    }

    @Override
    public Inventory findOne(Integer idInventory) {
       return repository.findOne(idInventory);
    }

    @Override
    public void deleteInventory(Integer idInventory) {
        repository.delete(idInventory);
    }
    
}
