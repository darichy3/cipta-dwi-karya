package id.cipta.dwi.karya.ciptadwikarya.repository;

import id.cipta.dwi.karya.ciptadwikarya.domain.Transaction;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByTransactionDate(String transactionDate);

    List<Transaction> findByTransactionDateBetween(String tglAwal, String tglAkhir);

    Transaction findByIdTransaction(Integer idTransaction);
}
