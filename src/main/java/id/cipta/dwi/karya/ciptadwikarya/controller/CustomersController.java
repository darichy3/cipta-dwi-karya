package id.cipta.dwi.karya.ciptadwikarya.controller;

import id.cipta.dwi.karya.ciptadwikarya.domain.Customers;
import id.cipta.dwi.karya.ciptadwikarya.domain.Users;
import id.cipta.dwi.karya.ciptadwikarya.form.FormCustomers;
import id.cipta.dwi.karya.ciptadwikarya.service.CustomersService;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customer")
public class CustomersController {
    
    private static final Logger logger = LoggerFactory.getLogger(CustomersController.class);
    
    @Autowired
    private CustomersService customersService;
    
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
        
        return "redirect:/customer/add";        
    }
    
}
