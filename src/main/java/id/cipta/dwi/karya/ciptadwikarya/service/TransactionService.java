package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Transaction;
import java.util.List;


public interface TransactionService {
    public Transaction saveTransaction(Transaction transaction);
    
    public Transaction updateTransaction(Transaction transaction);
    
    List<Transaction> findAll();
    
    Transaction findOne(Integer idTransaction);
    
    void deleteTransaction(Integer idTransaction);
}
