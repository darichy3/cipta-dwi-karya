package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Customers;
import java.util.Date;
import java.util.List;

public interface CustomersReportService {
    public List<Customers> reportCustomer(Date tglAwal, Date tglAkhir); 
}
