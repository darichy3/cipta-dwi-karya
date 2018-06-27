package id.cipta.dwi.karya.ciptadwikarya.controller;

import id.cipta.dwi.karya.ciptadwikarya.domain.Transaction;
import id.cipta.dwi.karya.ciptadwikarya.form.FormTransaction;
import id.cipta.dwi.karya.ciptadwikarya.repository.TransactionRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.TransactionRepository;
import id.cipta.dwi.karya.ciptadwikarya.service.TransactionService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
    
    @Autowired
    private TransactionService transactionService;
    
    @Autowired
    private TransactionRepository transactionRepository; 
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String GetAddAction(FormTransaction formTransaction){
        
        return "addTransaction";        
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String PostAddAction(FormTransaction formTransaction){
        
//        Transaction transaction = new Transaction();
//        transaction.setName(formTransaction.getName());
//        transaction.setSumIn(formTransaction.getSumIn());
//        transaction.setSumOut(0);
//        transaction.setSumEnd(0);
//        transaction.setNote(formTransaction.getNote());
        
//        transactionService.saveTransaction(transaction);
        
        logger.info(formTransaction.toString());
        
        return "redirect:/transaction/menu";        
    }
    
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String GetMenuAction(Model model, @Valid @ModelAttribute("transactions") Transaction transactions){
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDateTime now = LocalDateTime.now();
        logger.info("Date to day: "+dtf.format(now)); 
        
        model.addAttribute("transactions", transactionRepository.findByTransactionDate(dtf.format(now)));
        
        return "menuTransaction";        
    }
    
    @RequestMapping(value={"/edit","/edit/{idTransaction}"}, method = RequestMethod.GET)
    public String GetEditAction(Model model, @PathVariable(required = false, name = "idTransaction") Integer idTransaction) {
        if (null != idTransaction) {
                model.addAttribute("transactions", transactionService.findOne(idTransaction));
        } else {
            model.addAttribute("transactions", new Transaction());
        }
        return "editTransaction";
    }
    
    @RequestMapping(value={"/edit","/edit/{idTransaction}"}, method = RequestMethod.POST)
    public String PostEditAction(Model model, @Valid @ModelAttribute("transactions") Transaction transactions, FormTransaction formTransaction) {
        
//        transactions.setName(formTransaction.getName());
//        transactions.setSumIn(formTransaction.getSumIn());
//        transactions.setNote(formTransaction.getName());
        
//        transactionService.updateTransaction(transactions);
        logger.info(formTransaction.toString());
//        model.addAttribute("transactions", transactionService.findAll());
        return "menuTransaction";
    }

    @RequestMapping(value="/delete/{idTransaction}", method = RequestMethod.GET)
    public String GetDeleteAction(Model model, @PathVariable(required = true, name = "idTransaction") Integer idTransaction) {
        transactionService.deleteTransaction(idTransaction);
        model.addAttribute("transactions", transactionService.findAll());
        return "menuTransaction";
    }
    
    
}
