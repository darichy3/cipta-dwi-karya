package id.cipta.dwi.karya.ciptadwikarya.controller;

import id.cipta.dwi.karya.ciptadwikarya.domain.Customers;
import id.cipta.dwi.karya.ciptadwikarya.domain.Inventory;
import id.cipta.dwi.karya.ciptadwikarya.domain.Status;
import id.cipta.dwi.karya.ciptadwikarya.domain.Transaction;
import id.cipta.dwi.karya.ciptadwikarya.domain.Users;
import id.cipta.dwi.karya.ciptadwikarya.form.FormTransaction;
import id.cipta.dwi.karya.ciptadwikarya.repository.CustomersRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.InventoryRepository;
import id.cipta.dwi.karya.ciptadwikarya.repository.StatusRepository;
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
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private StatusRepository statusRepository;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime now = LocalDateTime.now();

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

        logger.info("Date to day: " + dtf.format(now));

        try {
            Transaction transaction = new Transaction();
            transaction.setTransactionDate(dtf.format(now));
            transaction.setNoSuratJalan("");
            transaction.setTglSuratJalan(dtf.format(now));
            transaction.setDeliveryDate(formTransaction.getDeliveryDate());
            transaction.setQuantity(formTransaction.getQuantity());
            transaction.setIdUser(userRepository.findByName(loginUser));
            transaction.setIdCustomer(customerRepository.findByIdCustomer(formTransaction.getIdCustomer()));
            transaction.setIdInventory(inventoryRepository.findByIdInventory(formTransaction.getIdInventory()));
            int totalHarga = (formTransaction.getQuantity() * inventoryRepository.findByIdInventory(formTransaction.getIdInventory()).getPriceSell());
            transaction.setTotalHarga(totalHarga);
            transaction.setIdStatus(statusRepository.findByIdStatus(1));
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
    public String GetMenuAction(@RequestParam(name = "startDate", required = false) String startDate,
            @RequestParam(name = "endDate", required = false) String endDate,
            Model model) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        logger.info("Date to day: " + dtf.format(now));
        logger.info("Start Date: " + startDate);
        logger.info("End Date: " + endDate);

        if (startDate != null && endDate != null) {
            model.addAttribute("transactions", transactionRepository.findByTransactionDateBetween(startDate, endDate));
            model.addAttribute("startDate", startDate);
            model.addAttribute("endDate", endDate);
        } else {
            model.addAttribute("transactions", transactionRepository.findByTransactionDate(dtf.format(now)));
        }
        return "menuTransaction";
    }

    @RequestMapping(value = {"/edit/{idTransaction}"}, method = RequestMethod.GET)
    public String GetEditAction(Model model, @PathVariable(required = false, name = "idTransaction") Integer idTransaction) {

        Transaction transaction = transactionService.findOne(idTransaction);

        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("inventories", inventoryRepository.findAll());
        model.addAttribute("statuses", statusRepository.findAll());
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
            transactionService.updateTransaction(transactions);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/transaction/menu";
    }

    @RequestMapping(value = "/return/{idTransaction}", method = RequestMethod.GET)
    public String GetReturAction(Model model, @PathVariable(required = true, name = "idTransaction") Integer idTransaction) {
        Transaction transaction = transactionService.findOne(idTransaction);
        Status status = statusRepository.findByName("Retur");
        transaction.setIdStatus(status);
        transactionService.returTransaction(transaction);
//        model.addAttribute("transactions", transactionRepository.findByTransactionDate(dtf.format(now)));
//        return "menuTransaction";
        return "redirect:/transaction/menu";
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
