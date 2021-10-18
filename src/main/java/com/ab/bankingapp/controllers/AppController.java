package com.ab.bankingapp.controllers;

import com.ab.bankingapp.models.BankAcc;
import com.ab.bankingapp.models.Transactions;
import com.ab.bankingapp.services.BankAccService;
import com.ab.bankingapp.services.CustomerService;
import com.ab.bankingapp.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    CustomerService cs;

    @Autowired
    TransactionService ts;

    @Autowired
    BankAccService bs;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showLanding() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/createAccount", method = RequestMethod.GET)
    public  ModelAndView createAcc(Model model) {
        BankAcc b = new BankAcc();
        model.addAttribute("b", b);
        return new ModelAndView("createAccount");
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    public  ModelAndView transactions(Model model) {
        Transactions t = new Transactions();
        model.addAttribute("t", t);
        return new ModelAndView("transactions");
    }

    @RequestMapping(value = "/viewAccount")
    public  ModelAndView viewAcc(Model model) {
        BankAcc b = new BankAcc();
        model.addAttribute("ba", b);
        return new ModelAndView("viewAccount");
    }

    @PostMapping(value = "/view")
    public ModelAndView acc(@ModelAttribute("acc_no") String acc_no, Model model) {
        List<BankAcc> bl = bs.listAll();
        BankAcc ba = new BankAcc();
        ba = bs.viewAcc(bl, acc_no);
        model.addAttribute("ba", ba);
        return new ModelAndView("viewAccount");
    }

    @PostMapping("/save")
    public String saveBankAcc(BankAcc b,
                              @ModelAttribute("type") String type,
                               @ModelAttribute("f_name") String fName,
                               @ModelAttribute("l_name") String lName,
                               @ModelAttribute("bal") double bal,
                               @ModelAttribute("date") String date,
                               Model model){

        String acc_no = bs.genAccNo(type);
        b.setAcc_no(acc_no);
        model.addAttribute("f_name", fName);
        model.addAttribute("l_name", lName);
        model.addAttribute("bal", bal);
        model.addAttribute("date", date);
        bs.save(b);
        return "viewAccount";

    }

    @PostMapping(value = "/transactions", params ="deposit")
    public String deposit(Transactions t,
                              @ModelAttribute("acc_no") String acc_no,
                          @ModelAttribute("type") String type,
                              @ModelAttribute("amount") double amount,
                              Model model){


        List<BankAcc> bankAcc = bs.listAll();
        model.addAttribute("type", type);
        model.addAttribute("acc_no", acc_no);
        model.addAttribute("amount", amount);
        ts.deposit(bankAcc, t, acc_no, amount);
        ts.save(t);
        return "viewAccount";
    }

    @PostMapping(value = "/transactions", params ="withdraw")
    public String withdraw(Transactions t,
                          @ModelAttribute("acc_no") String acc_no,
                          @ModelAttribute("type") String type,
                          @ModelAttribute("amount") double amount,
                          @ModelAttribute("date") String date,
                          Model model){

        List<BankAcc> bankAcc = bs.listAll();
        model.addAttribute("type", type);
        model.addAttribute("acc_no", acc_no);
        model.addAttribute("amount", amount);
        model.addAttribute("date", date);
        ts.withdraw(bankAcc, t, acc_no, amount);
        ts.save(t);
        return "viewAccount";
    }









}
