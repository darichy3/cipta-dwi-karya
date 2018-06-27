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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

@Controller
@RequestMapping("/report")
public class ReportSafeCondustController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/safeConduct/{idTrans}", method = RequestMethod.GET)
    public ModelAndView viewReport(@PathVariable("idTrans") int idTrans) {

        JasperReportsPdfView jPdf = new JasperReportsPdfView();
        jPdf.setUrl("classpath:report/reportSafeConduct.jrxml");
        jPdf.setApplicationContext(applicationContext);
        Map<String, Object> params = new HashMap();
        params.put("datasource", dataTransaction(idTrans));
        return new ModelAndView(jPdf, params);
    }

    private FormSafeConduct dataTransaction(int id) {

        Transaction transaction = transactionService.findOne(id);

        FormSafeConduct formSafeConduct = new FormSafeConduct();
        formSafeConduct.setAdmin(transaction.getIdUser().getName());
        formSafeConduct.setBarang(transaction.getIdInventory().getName());
        formSafeConduct.setCustAddress(transaction.getIdCustomer().getAddress());
        formSafeConduct.setCustName(transaction.getIdCustomer().getName());
        formSafeConduct.setCustPhone(transaction.getIdCustomer().getPhone());
        formSafeConduct.setDelivDate(parseToDate(transaction.getDeliveryDate()));
        formSafeConduct.setNote(transaction.getNote());
        formSafeConduct.setQuantity(transaction.getQuantity());
        formSafeConduct.setTransDate(parseToDate(transaction.getTransactionDate()));

        return formSafeConduct;
    }

    private Date parseToDate(String tgl) {
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
