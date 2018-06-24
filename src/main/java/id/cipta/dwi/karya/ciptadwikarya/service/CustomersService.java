package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Customers;
import java.util.List;


public interface CustomersService {
   
    public Customers saveCustomer(Customers customers);
    
    public Customers updateCustomers(Customers customers);
    
    List<Customers> findAll();
    
    Customers findOne(Integer id);
    
    void deleteCustomer(Integer id);
    
}
