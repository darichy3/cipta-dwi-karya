package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Inventory;
import id.cipta.dwi.karya.ciptadwikarya.domain.Jurnal;
import id.cipta.dwi.karya.ciptadwikarya.domain.Status;
import id.cipta.dwi.karya.ciptadwikarya.domain.Transaction;
import id.cipta.dwi.karya.ciptadwikarya.form.FormTransaction;
import id.cipta.dwi.karya.ciptadwikarya.repository.AkunRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.CustomersRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.InventoryRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.JurnalRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.StatusRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.TransactionRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.UsersRepository;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
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
public class JurnalServiceImpl implements JurnalService{
    
    @Autowired
    private JurnalRepository repository;

    @Override
    public Jurnal saveJurnal(Jurnal jurnal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Jurnal updateJurnal(Jurnal jurnal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Jurnal> findAll() {
        return repository.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Jurnal> findByTglJurnalBetween(String tglAwal, String tglAkhir) {
        return repository.findByTglJurnalBetween(tglAwal, tglAkhir); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Jurnal findOne(Integer idJurnal) {
        return repository.findOne(idJurnal); //To change body of generated methods, choose Tools | Templates.
    }
       
}
