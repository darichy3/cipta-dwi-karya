package id.cipta.dwi.karya.ciptadwikarya.controller;

import id.cipta.dwi.karya.ciptadwikarya.domain.Customers;
import id.cipta.dwi.karya.ciptadwikarya.form.FormCustomers;
import id.cipta.dwi.karya.ciptadwikarya.repository.CustomersRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.CustomersRepository;
import id.cipta.dwi.karya.ciptadwikarya.service.CustomersService;
import java.util.Date;
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
@RequestMapping("/customer")
public class CustomersController {
    
    private static final Logger logger = LoggerFactory.getLogger(CustomersController.class);
    
    @Autowired
    private CustomersService customersService;
    
     @Autowired
    private CustomersRepository customersRepository; 
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String GetAddAction(FormCustomers formCustomers){
        
        return "addCustomer";        
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String PostAddAction(FormCustomers formCustomers){

        
        Customers customers = new Customers();
        customers.setName(formCustomers.getName());
        customers.setAddress(formCustomers.getAddress());
        customers.setPhone(formCustomers.getPhone());
        customers.setCreated_by("admin");
        
        customersService.saveCustomer(customers);
        
        logger.info(formCustomers.toString());
        
        return "redirect:/customer/menu";        
    }
    
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String GetMenuAction(Model model){
        
        model.addAttribute("customers", customersRepository.findAll());
        
        return "menuCustomers";        
    }
    
     @RequestMapping(value={"/edit","/edit/{id}"}, method = RequestMethod.GET)
    public String GetEditAction(Model model, @PathVariable(required = false, name = "id") Integer id) {
        if (null != id) {
                model.addAttribute("customers", customersService.findOne(id));
        } else {
            model.addAttribute("customers", new Customers());
        }
        return "editCustomers";
    }
    
    @RequestMapping(value={"/edit","/edit/{id}"}, method = RequestMethod.POST)
    public String PostEditAction(Model model, @Valid @ModelAttribute("customers") Customers customers, FormCustomers formCustomers) {
        
        customers.setName(formCustomers.getName());
        customers.setAddress(formCustomers.getAddress());
        customers.setPhone(formCustomers.getPhone());
        customers.setCreated_by("admin");
        
        customersService.updateCustomers(customers);
        logger.info(formCustomers.toString());
        model.addAttribute("customers", customersService.findAll());
        return "menuCustomers";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String GetDeleteAction(Model model, @PathVariable(required = true, name = "id") Integer id) {
        customersService.deleteCustomer(id);
        model.addAttribute("customers", customersService.findAll());
        return "menuCustomers";
    }
    
}
