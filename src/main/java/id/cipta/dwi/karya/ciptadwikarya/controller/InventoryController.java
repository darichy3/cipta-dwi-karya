package id.cipta.dwi.karya.ciptadwikarya.controller;

import id.cipta.dwi.karya.ciptadwikarya.domain.Inventory;
import id.cipta.dwi.karya.ciptadwikarya.form.FormInventory;
import id.cipta.dwi.karya.ciptadwikarya.repository.InventoryRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.InventoryRepository;
import id.cipta.dwi.karya.ciptadwikarya.service.InventoryService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        logger.info("Date to day: " + dtf.format(now));
        
        Inventory inventory = new Inventory();
        inventory.setName(formInventory.getName());
        inventory.setPriceBuy(formInventory.getPriceBuy());
        inventory.setPriceSell(formInventory.getPriceSell());
        inventory.setSumIn(formInventory.getSumIn());
        inventory.setSumOut(0);
        inventory.setSumEnd(0);
        inventory.setDateIn(dtf.format(now));
        inventory.setNote(formInventory.getNote());
        
        inventoryService.saveInventory(inventory);
        
        logger.info(formInventory.toString());
        
        return "redirect:/inventory/menu";        
    }
    
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String GetMenuAction(Model model){
        
        model.addAttribute("inventories", inventoryRepository.findAll());
        
        return "menuInventory";        
    }
    
    @RequestMapping(value={"/edit","/edit/{idInventory}"}, method = RequestMethod.GET)
    public String GetEditAction(Model model, @PathVariable(required = false, name = "idInventory") Integer idInventory) {
        if (null != idInventory) {
                model.addAttribute("inventories", inventoryService.findOne(idInventory));
                logger.info(inventoryService.findOne(idInventory).getDateIn());
        } else {
            model.addAttribute("inventories", new Inventory());
        }
        return "editInventory";
    }
    
    @RequestMapping(value={"/edit","/edit/{idInventory}"}, method = RequestMethod.POST)
    public String PostEditAction(Model model, @Valid @ModelAttribute("inventories") Inventory inventories, FormInventory formInventory) {
        
        inventories.setName(formInventory.getName());
        inventories.setPriceBuy(formInventory.getPriceBuy());
        inventories.setPriceSell(formInventory.getPriceSell());
        inventories.setSumIn(formInventory.getSumIn());
        inventories.setNote(formInventory.getNote());
        
        inventoryService.updateInventory(inventories);
        logger.info(formInventory.toString());
        model.addAttribute("inventories", inventoryService.findAll());
        return "menuInventory";
    }

    @RequestMapping(value="/delete/{idInventory}", method = RequestMethod.GET)
    public String GetDeleteAction(Model model, @PathVariable(required = true, name = "idInventory") Integer idInventory) {
        inventoryService.deleteInventory(idInventory);
        model.addAttribute("inventories", inventoryService.findAll());
        return "menuInventory";
    }
    
}
