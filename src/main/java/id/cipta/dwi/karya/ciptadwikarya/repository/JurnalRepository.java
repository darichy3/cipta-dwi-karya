package id.cipta.dwi.karya.ciptadwikarya.repository;

import id.cipta.dwi.karya.ciptadwikarya.domain.Jurnal;
import id.cipta.dwi.karya.ciptadwikarya.domain.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JurnalRepository extends JpaRepository<Jurnal, Integer>{
    
    List<Jurnal> findByTglJurnal(String transactionDate);

    List<Jurnal> findByTglJurnalBetween(String tglAwal, String tglAkhir);

    Jurnal findByIdJurnal(Integer idJurnal);
}
