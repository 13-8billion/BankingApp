package com.ab.bankingapp.services;

import com.ab.bankingapp.models.BankAcc;
import com.ab.bankingapp.models.Transactions;
import com.ab.bankingapp.repos.TransactionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    LocalDate date = LocalDate.now();

    @Autowired
    private TransactionsRepo repo;

    public List<Transactions> listAll() {
        return repo.findAll();
    }

    public void save(Transactions t) {
        repo.save(t);
    }

    public Transactions get(int t) {
        return repo.findById(t).get();
    }

    public void delete(int t) {
        repo.deleteById(t);
    }

    public void deposit(List<BankAcc> bankAcc, Transactions t, String acc_no, double amount) {
        double newBal = 0;

        for (int i = 0; i < bankAcc.size(); i++) {

            if (acc_no.equals(bankAcc.get(i).getAcc_no())) {

                double bal = bankAcc.get(i).getBal();
                newBal = bal + amount;
                bankAcc.get(i).setBal(newBal);
                t.setBal(newBal);
                t.setType(Transactions.Type.DEPOSIT);
                t.setDate(date);
            }
        }
    }

    public void withdraw(List<BankAcc> bankAcc, Transactions t, String acc_no, double amount) {
        double newBal = 0;

        for (int i = 0; i < bankAcc.size(); i++) {

            if (acc_no.equals(bankAcc.get(i).getAcc_no())) {

                double bal = bankAcc.get(i).getBal();
                newBal = bal - amount;
                bankAcc.get(i).setBal(newBal);
                t.setBal(newBal);
                t.setType(Transactions.Type.WITHDRAW);
                t.setDate(date);
            }
        }
    }

    public void openbal(List<BankAcc> bankAcc, Transactions t, String acc_no, double amount) {
        double newBal = 0;

        for (int i = 0; i < bankAcc.size(); i++) {

            if (acc_no.equals(bankAcc.get(i).getAcc_no())) {

                double bal = bankAcc.get(i).getBal();
                newBal = bal - amount;
                bankAcc.get(i).setBal(newBal);
                t.setBal(newBal);
            }
        }
    }
}
