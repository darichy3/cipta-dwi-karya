package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Inventory;
import id.cipta.dwi.karya.ciptadwikarya.domain.Status;
import id.cipta.dwi.karya.ciptadwikarya.domain.Transaction;
import id.cipta.dwi.karya.ciptadwikarya.form.FormTransaction;
import id.cipta.dwi.karya.ciptadwikarya.repository.CustomersRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.InventoryRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.StatusRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.TransactionRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.UsersRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class TransactionServiceImpl implements TransactionService{
    
    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
    
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UsersRepository userRepository;
    
    @Autowired
    private InventoryRepository inventoryRepository;
    
    @Autowired
    private StatusRepository statusRepository;
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter dtfYear = DateTimeFormatter.ofPattern("yyyy");
    LocalDateTime now = LocalDateTime.now();
        
   
    @Override
    @Transactional
    public Transaction saveTransaction(Transaction transaction) {
        
        if(transaction != null){
            if (transaction.getIdTransaction() >0) {
                Transaction transValid = repository.findOne(transaction.getIdTransaction());
                transaction.setTransactionDate(transValid.getTransactionDate());
                transaction = repository.save(transaction);
            }else{
                transaction = repository.save(transaction);
            }
            logger.info(transaction.toString());
            
            if(transaction != null){
            Inventory inventory = inventoryRepository.findOne(transaction.getIdInventory().getIdInventory());
            Integer validSumOut = inventoryRepository.findOne(transaction.getIdInventory().getIdInventory()).getSumOut();
            Integer validSumEnd = inventoryRepository.findOne(transaction.getIdInventory().getIdInventory()).getSumEnd();
            if(validSumOut==0){
                inventory.setSumOut(transaction.getQuantity());
            }else{
                inventory.setSumOut(validSumOut+transaction.getQuantity());
            }
            if(validSumEnd==0){
                inventory.setSumEnd(inventory.getSumIn()-transaction.getQuantity());
            }else{
                inventory.setSumEnd(validSumEnd-transaction.getQuantity());
            }
            
            inventory = inventoryRepository.save(inventory);
            logger.info(inventory.toString());
            }       
        }        
        return transaction;        
    }

    @Override
    public Transaction updateTransaction(@Valid @ModelAttribute("transactions") Transaction transactions) {
        logger.info("Form: "+transactions.toString());
        if(transactions != null){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String loginUser = authentication.getName();
            
            Transaction transactionDb = repository.findByIdTransaction(transactions.getIdTransaction());
            transactionDb.setDeliveryDate(transactions.getDeliveryDate());
            transactionDb.setQuantity(transactions.getQuantity());
            transactionDb.setIdUser(userRepository.findByName(loginUser));
            transactionDb.setIdInventory(transactions.getIdInventory());
            transactionDb.setIdCustomer(transactions.getIdCustomer());
            transactionDb.setIdStatus(transactions.getIdStatus());
            transactionDb.setNote(transactions.getNote());
            repository.save(transactionDb); 
            logger.info("DB: "+transactionDb.toString()); 
            
            if(transactionDb != null){
            Inventory inventory = inventoryRepository.findOne(transactionDb.getIdInventory().getIdInventory());
            Integer validSumOut = inventoryRepository.findOne(transactionDb.getIdInventory().getIdInventory()).getSumOut();
            Integer validSumEnd = inventoryRepository.findOne(transactionDb.getIdInventory().getIdInventory()).getSumEnd();
            if(validSumOut==0){
                inventory.setSumOut(transactionDb.getQuantity());
            }else{
                inventory.setSumOut(validSumOut+transactionDb.getQuantity());
            }
            if(validSumEnd==0){
                inventory.setSumEnd(inventory.getSumIn()-transactionDb.getQuantity());
            }else{
                inventory.setSumEnd(validSumEnd-transactionDb.getQuantity());
            }
            
            inventory = inventoryRepository.save(inventory);
            }
        }        
        return transactions;   
    }
    
    @Override
    public Transaction returTransaction(@Valid @ModelAttribute("transactions") Transaction transactions) {
        logger.info("Form: "+transactions.toString());
        if(transactions != null){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String loginUser = authentication.getName();
  
            Transaction transactionDb = repository.findByIdTransaction(transactions.getIdTransaction());
            transactionDb.setIdUser(userRepository.findByName(loginUser));
            transactionDb.setIdStatus(transactions.getIdStatus());
            transactionDb.setQuantity(-transactions.getQuantity());
            transactionDb.setTotalHarga(-transactions.getTotalHarga());
            
            repository.save(transactionDb); 
            logger.info("TrnsactionDB: "+transactionDb.toString()); 
     
            if(transactionDb != null){
            Inventory inventory = inventoryRepository.findOne(transactionDb.getIdInventory().getIdInventory());
            Integer validSumOut = inventoryRepository.findOne(transactionDb.getIdInventory().getIdInventory()).getSumOut();
            Integer validSumEnd = inventoryRepository.findOne(transactionDb.getIdInventory().getIdInventory()).getSumEnd();
            
            inventory.setSumOut(validSumOut-transactionDb.getQuantity());
            inventory.setSumEnd(validSumEnd+transactionDb.getQuantity());
                
            inventory = inventoryRepository.save(inventory);
              logger.info("Inventory update"+inventory.toString());
            }
        }        
        return transactions;   
    }
    
    @Override
    @Transactional
    public Transaction updateSuratJalan(Transaction transaction) {
        logger.info("Year to day: " + dtfYear.format(now));
        if(transaction != null){
            repository.findByIdTransaction(transaction.getIdTransaction());
            transaction.setNoSuratJalan("SJ/0"+transaction.getIdTransaction()+"/"+dtfYear.format(now));
            transaction.setTglSuratJalan(dtf.format(now));
            repository.save(transaction);
        }
        return transaction;        
    }

    @Override
    public List<Transaction> findAll() {
        return repository.findAll();
    }

    @Override
    public Transaction findOne(Integer idTransaction) {
       return repository.findOne(idTransaction);
    }

    @Override
    public void deleteTransaction(Integer idTransaction) {
        Transaction transaction = repository.findOne(idTransaction);
        
        Inventory invenTrans = transaction.getIdInventory();
        
        Status changeStatus = statusRepository.findByName("Retur");
        
        
        
        repository.delete(idTransaction);
    }

    @Override
    public List<Transaction> findByTransactionDateBetween(String tglAwal, String tglAkhir) {
        return repository.findByTransactionDateBetween(tglAwal, tglAkhir);
    }
    
}
