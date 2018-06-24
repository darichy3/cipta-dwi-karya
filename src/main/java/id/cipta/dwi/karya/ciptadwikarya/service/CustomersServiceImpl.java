package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Customers;
import id.cipta.dwi.karya.ciptadwikarya.domain.Users;
import id.cipta.dwi.karya.ciptadwikarya.repository.CustomersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
}
