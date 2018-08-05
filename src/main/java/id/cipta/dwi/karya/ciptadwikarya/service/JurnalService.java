package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Jurnal;
import id.cipta.dwi.karya.ciptadwikarya.domain.Transaction;
import java.util.List;


public interface JurnalService {
    public Jurnal saveJurnal(Jurnal jurnal);
    
    public Jurnal updateJurnal(Jurnal jurnal);
    
    List<Jurnal> findAll();

    public List<Jurnal> findByTglJurnalBetween(String tglAwal, String tglAkhir);
    
    Jurnal findOne(Integer idJurnal);
}
