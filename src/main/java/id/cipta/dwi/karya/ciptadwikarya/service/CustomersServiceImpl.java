package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Customers;
import id.cipta.dwi.karya.ciptadwikarya.domain.Users;
import id.cipta.dwi.karya.ciptadwikarya.repository.CustomersRepository;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class CustomersServiceImpl implements CustomersService{
    
    private static final Logger logger = LoggerFactory.getLogger(CustomersServiceImpl.class);
    
    @Autowired
    private CustomersRepository repository;

    @Override
    @Transactional
    public Customers saveCustomer(Customers customers) {
        if(customers != null){
            Customers customerValid = repository.save(customers);
            if(customers != null){
                logger.info(customerValid.toString());
            }            
        }        
        return customers; 
    }

    @Override
    @Transactional
    public Customers updateCustomers(@Valid @ModelAttribute("customers") Customers customers) {
        logger.info("Result customers: "+customers.toString());
        if(customers != null){
            Customers customersDb = repository.findById(customers.getId());
            customersDb.setName(customers.getName());
            customersDb.setAddress(customers.getAddress());
            customersDb.setPhone(customers.getPhone());
            customersDb.setCreatedBy(customers.getName());
            repository.save(customersDb);
            logger.info("Data customers: "+customersDb.toString());        
        }        
        return customers;     
    }

    @Override
    public List<Customers> findAll() {
        return repository.findAll();
    }

    @Override
    public Customers findOne(Integer id) {
       return repository.findOne(id);
    }

    @Override
    public void deleteCustomer(Integer id) {
        repository.delete(id);
    }
    
}
