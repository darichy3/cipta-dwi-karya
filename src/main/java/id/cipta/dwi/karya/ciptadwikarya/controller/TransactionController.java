package id.cipta.dwi.karya.ciptadwikarya.controller;

import id.cipta.dwi.karya.ciptadwikarya.domain.Customers;
import id.cipta.dwi.karya.ciptadwikarya.domain.Inventory;
import id.cipta.dwi.karya.ciptadwikarya.domain.Transaction;
import id.cipta.dwi.karya.ciptadwikarya.domain.Users;
import id.cipta.dwi.karya.ciptadwikarya.form.FormTransaction;
import id.cipta.dwi.karya.ciptadwikarya.repository.CustomersRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.InventoryRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.TransactionRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.TransactionRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.UsersRepository;
import id.cipta.dwi.karya.ciptadwikarya.service.TransactionService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private CustomersRepository customerRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private UsersRepository userRepository;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String GetAddAction(FormTransaction formTransaction, Model model, Customers customer, Inventory inventory) {

        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("inventories", inventoryRepository.findAll());
        return "addTransaction";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String PostAddAction(FormTransaction formTransaction) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loginUser = authentication.getName();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        logger.info("Date to day: " + dtf.format(now));

        try {
            Transaction transaction = new Transaction();
            transaction.setTransactionDate(dtf.format(now));
            transaction.setDeliveryDate(formTransaction.getDeliveryDate());
            transaction.setQuantity(formTransaction.getQuantity());
            transaction.setIdUser(userRepository.findByName(loginUser));
            transaction.setIdCustomer(customerRepository.findByIdCustomer(formTransaction.getIdCustomer()));
            transaction.setIdInventory(inventoryRepository.findByIdInventory(formTransaction.getIdInventory()));
            transaction.setNote(formTransaction.getNote());

            transactionService.saveTransaction(transaction);

            logger.info(formTransaction.toString());
            logger.info(transaction.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/transaction/menu";
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String GetMenuAction(Model model, @Valid @ModelAttribute("transactions") Transaction transactions) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        logger.info("Date to day: " + dtf.format(now));

        model.addAttribute("transactions", transactionRepository.findByTransactionDate(dtf.format(now)));

        return "menuTransaction";
    }

    @RequestMapping(value = {"/edit/{idTransaction}"}, method = RequestMethod.GET)
    public String GetEditAction(Model model, @PathVariable(required = false, name = "idTransaction") Integer idTransaction) {
        
        Transaction transaction = transactionService.findOne(idTransaction);
        
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("inventories", inventoryRepository.findAll());
        model.addAttribute("transactions", transaction);

        return "editTransaction";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    public String PostEditAction(Model model, Transaction transactions) {
        logger.info(transactions.toString());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loginName = auth.getName();
        try {
            Users users = userRepository.findByUsername(loginName);
            transactions.setIdUser(users);
            transactionService.saveTransaction(transactions);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/transaction/menu";
    }

    @RequestMapping(value = "/delete/{idTransaction}", method = RequestMethod.GET)
    public String GetDeleteAction(Model model, @PathVariable(required = true, name = "idTransaction") Integer idTransaction) {
        transactionService.deleteTransaction(idTransaction);
        model.addAttribute("transactions", transactionService.findAll());
        return "menuTransaction";
    }

    @RequestMapping(value = {"/print", "/print/{idTransaction}"}, method = RequestMethod.GET)
    public String GetPrintAction(Model model, @PathVariable(required = false, name = "idTransaction") Integer idTransaction) {
        if (null != idTransaction) {
            model.addAttribute("transactions", transactionService.findOne(idTransaction));
        } else {
            model.addAttribute("transactions", new Transaction());
        }
        return "editTransaction";
    }
}
