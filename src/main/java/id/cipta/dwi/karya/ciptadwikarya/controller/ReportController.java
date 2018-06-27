package id.cipta.dwi.karya.ciptadwikarya.controller;

import id.cipta.dwi.karya.ciptadwikarya.domain.Customers;
import id.cipta.dwi.karya.ciptadwikarya.service.CustomersReportService;
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

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private CustomersReportService customersReportService;

    @RequestMapping(value = "/customers")
    public String ReportAction() {
        return "laporan";
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public ModelAndView viewReport(HttpServletRequest request) {
        
        String jnsLap = request.getParameter("jnsLap");
        String tglAwal = request.getParameter("tglAwal");
        String tglAkhir = request.getParameter("tglAkhir");

        JasperReportsPdfView jPdf = new JasperReportsPdfView();
        jPdf.setUrl("classpath:report/reportCustomer.jrxml");
        jPdf.setApplicationContext(applicationContext);
        Map<String, Object> params = new HashMap();
        
        if(jnsLap.trim().equalsIgnoreCase("Report Customers")){
             params.put("datasource", dataCustomers(tglAwal, tglAkhir));
        }else if(jnsLap.trim().equalsIgnoreCase("Report Transaction")){ //disamakan dengan combobox html
             params.put("datasource", dummyData());        
        }else{
            params.put("datasource", dummyData());        
        }
        
        params.put("jenisLaporan", jnsLap);
        params.put("tanggalAwal", parseToDate(tglAwal));
        params.put("tanggalAkhir", parseToDate(tglAkhir));
        return new ModelAndView(jPdf, params);
    }
    
    private List<Customers> dummyData(){
        List<Customers> customerses = new ArrayList();
        for(int i = 0 ; i<5; i++){
            Customers customers = new Customers();
            customers.setName("Dummy "+i+" Name");
            customers.setAddress("Dummy "+i+" Address");
            customers.setPhone("Dummy "+i+" Phone");
            customerses.add(customers);
        }
        return customerses;
    }
    
    private List<Customers> dataCustomers(String tglAwal, String tglAkhir){
        return customersReportService.reportCustomer(parseToDate(tglAwal), parseToDate(tglAkhir));
    }
    
    private Date parseToDate(String tgl){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(tgl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
}

}
