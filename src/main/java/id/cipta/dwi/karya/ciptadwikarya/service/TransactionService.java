package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Transaction;
import java.util.List;


public interface TransactionService {
    public Transaction saveTransaction(Transaction transaction);
    
    public Transaction updateTransaction(Transaction transaction);
    
    List<Transaction> findAll();

    public List<Transaction> findByTransactionDateBetween(String tglAwal, String tglAkhir);
    
    Transaction findOne(Integer idTransaction);
    
    void deleteTransaction(Integer idTransaction);
    
    public Transaction updateSuratJalan(Transaction transaction);
}
