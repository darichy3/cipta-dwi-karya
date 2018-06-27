package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Transaction;
import id.cipta.dwi.karya.ciptadwikarya.repository.TransactionRepository;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class TransactionServiceImpl implements TransactionService{
    
    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
    
    @Autowired
    private TransactionRepository repository;
   
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
                   
        }        
        return transaction;        
    }

    @Override
    public Transaction updateTransaction(@Valid @ModelAttribute("transactions") Transaction transactions) {
        logger.info("Result transaction: "+transactions.toString());
//        if(transactions != null){
//            Transaction transactionDb = repository.findByIdTransaction(transactions.getIdTransaction());
//            transactionDb.setName(transactions.getName());
//            transactionDb.setSumIn(transactions.getSumIn());
//            transactionDb.setSumOut(0);
//            transactionDb.setSumEnd(0);
//            transactionDb.setNote(transactions.getNote());
//            repository.save(transactionDb);
//            logger.info(transactionDb.toString());        
//        }        
        return transactions;   
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
        repository.delete(idTransaction);
    }

    @Override
    public List<Transaction> findByTransactionDateBetween(String tglAwal, String tglAkhir) {
        return repository.findByTransactionDateBetween(tglAwal, tglAkhir);
    }
    
}
