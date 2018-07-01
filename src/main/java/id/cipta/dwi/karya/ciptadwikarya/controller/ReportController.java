package id.cipta.dwi.karya.ciptadwikarya.controller;

import id.cipta.dwi.karya.ciptadwikarya.domain.Customers;
import id.cipta.dwi.karya.ciptadwikarya.domain.Transaction;
import id.cipta.dwi.karya.ciptadwikarya.form.FormSafeConduct;
import id.cipta.dwi.karya.ciptadwikarya.service.CustomersReportService;
import id.cipta.dwi.karya.ciptadwikarya.service.TransactionService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsXlsView;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CustomersReportService customersReportService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/menu")
    public String ReportAction() {
        return "laporan";
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public ModelAndView viewReport(HttpServletRequest request) {

        String jnsLap = request.getParameter("jnsLap");
        String tglAwal = request.getParameter("tglAwal");
        String tglAkhir = request.getParameter("tglAkhir");

        JasperReportsPdfView jPdf = new JasperReportsPdfView();

        Map<String, Object> params = new HashMap();
        if (jnsLap.trim().equalsIgnoreCase("Report Customers")) {
            jPdf.setUrl("classpath:report/reportCustomer.jrxml");
            params.put("datasource", dataCustomers(tglAwal, tglAkhir));
        } else if (jnsLap.trim().equalsIgnoreCase("Report Transaction")) { //disamakan dengan combobox html
            jPdf.setUrl("classpath:report/reportTransactions.jrxml");
            params.put("datasource", dataListTransaction(tglAwal, tglAkhir));
        } else {
            jPdf.setUrl("classpath:report/reportCustomer.jrxml");
            params.put("datasource", dummyData());
        }

        jPdf.setApplicationContext(applicationContext);

        params.put("jenisLaporan", jnsLap);
        params.put("tanggalAwal", parseToDate(tglAwal));
        params.put("tanggalAkhir", parseToDate(tglAkhir));
        return new ModelAndView(jPdf, params);
    }

    private List<FormSafeConduct> dataListTransaction(String tglAwal, String tglAkhir) {

        List<Transaction> listTrans = transactionService.findByTransactionDateBetween(tglAwal, tglAkhir);

        List<FormSafeConduct> listForms = new ArrayList();
        
        Integer totalSales = 0;

        for (Transaction transaction : listTrans) {
            FormSafeConduct formSafeConduct = new FormSafeConduct();
            
            Integer totalPrice = transaction.getQuantity()*transaction.getIdInventory().getPriceSell();
            
            totalSales = totalSales+totalPrice;
            
            formSafeConduct.setAdmin(transaction.getIdUser().getName());
            formSafeConduct.setBarang(transaction.getIdInventory().getName());
            formSafeConduct.setCustAddress(transaction.getIdCustomer().getAddress());
            formSafeConduct.setCustName(transaction.getIdCustomer().getName());
            formSafeConduct.setCustPhone(transaction.getIdCustomer().getPhone());
            formSafeConduct.setDelivDate(parseToDate(transaction.getDeliveryDate()));
            formSafeConduct.setNote(transaction.getNote());
            formSafeConduct.setQuantity(transaction.getQuantity());
            formSafeConduct.setTransDate(parseToDate(transaction.getTransactionDate()));
            formSafeConduct.setStatus(transaction.getIdStatus().getName());
            formSafeConduct.setPriceSell(transaction.getIdInventory().getPriceSell());
            formSafeConduct.setTotalPrice(totalPrice);
            formSafeConduct.setTotalSales(totalSales);
            listForms.add(formSafeConduct);
        }

        return listForms;
    }

    private List<Customers> dummyData() {
        List<Customers> customerses = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Customers customers = new Customers();
            customers.setName("Dummy " + i + " Name");
            customers.setAddress("Dummy " + i + " Address");
            customers.setPhone("Dummy " + i + " Phone");
            customerses.add(customers);
        }
        return customerses;
    }

    private List<Customers> dataCustomers(String tglAwal, String tglAkhir) {
        return customersReportService.reportCustomer(tglAwal, tglAkhir);
    }

    private Date parseToDate(String tgl) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            if(tgl != null){
            date = sdf.parse(tgl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

}
