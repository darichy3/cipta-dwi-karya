package id.cipta.dwi.karya.ciptadwikarya.controller;

import id.cipta.dwi.karya.ciptadwikarya.domain.Inventory;
import id.cipta.dwi.karya.ciptadwikarya.form.FormInventory;
import id.cipta.dwi.karya.ciptadwikarya.repository.InventoryRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.UsersRepository;
import id.cipta.dwi.karya.ciptadwikarya.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
    
    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);
    
    @Autowired
    private InventoryService inventoryService;
    
    @Autowired
    private InventoryRepository inventoryRepository; 
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String GetAddAction(FormInventory formInventory){
        
        return "addInventory";        
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String PostAddAction(FormInventory formInventory){
        
        Inventory inventory = new Inventory();
        inventory.setName(formInventory.getName());
        inventory.setSumIn(formInventory.getSumIn());
        inventory.setSumOut(0);
        inventory.setSumEnd(0);
        inventory.setNote(formInventory.getNote());
        
        inventoryService.saveInventory(inventory);
        
        logger.info(formInventory.toString());
        
        return "redirect:/inventory/add";        
    }
    
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String GetMenuAction(Model model){
        
        model.addAttribute("inventories", inventoryRepository.findAll());
        
        return "menuInventory";        
    }
    
}
