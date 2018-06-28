package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Customers;
import id.cipta.dwi.karya.ciptadwikarya.domain.Users;
import id.cipta.dwi.karya.ciptadwikarya.repository.CustomersRepository;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String loginUser = authentication.getName();
        
            Customers customersDb = repository.findByIdCustomer(customers.getIdCustomer());
            customersDb.setName(customers.getName());
            customersDb.setAddress(customers.getAddress());
            customersDb.setPhone(customers.getPhone());
            customersDb.setCreatedBy(loginUser);
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
    public Customers findOne(Integer idCustomer) {
       return repository.findOne(idCustomer);
    }

    @Override
    public void deleteCustomer(Integer idCustomer) {
        repository.delete(idCustomer);
    }
    
}
