package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Inventory;
import java.util.List;


public interface InventoryService {
    public Inventory saveInventory(Inventory inventory);
    
    public Inventory updateInventory(Inventory inventory);
    
    List<Inventory> findAll();
    
    Inventory findOne(Integer idInventory);
    
    void deleteInventory(Integer idInventory);
}
