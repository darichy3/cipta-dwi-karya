package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Customers;
import id.cipta.dwi.karya.ciptadwikarya.repository.CustomersRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomersReportServiceImpl implements CustomersReportService{

    @Autowired
    private CustomersRepository repository;
    
    @Override
    public List<Customers> reportCustomer(String tglAwal, String tglAkhir) {
        return repository.findByCreatedDateBetween(tglAwal, tglAkhir);
    }
    
}
