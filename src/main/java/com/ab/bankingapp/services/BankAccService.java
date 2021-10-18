package com.ab.bankingapp.services;


import com.ab.bankingapp.models.BankAcc;
import com.ab.bankingapp.models.Transactions;
import com.ab.bankingapp.repos.BankAccRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.util.List;
import java.util.Random;

@Service
public class BankAccService {

    @Autowired
    private BankAccRepo repo;

//    public abstract void deposit();
//
//    public abstract void withdraw();

    @Autowired
    public final void setBankAccRepo(BankAccRepo repo) {
        this.repo = repo;
    }

    public List<BankAcc> listAll() {
        return repo.findAll();
    }

    public void save(BankAcc acc) {
        repo.save(acc);
    }

    public BankAcc get(int accNo) {
        return repo.findById(accNo).get();
    }

    public void delete(int accNo) {
        repo.deleteById(accNo);
    }

    public String genAccNo(String input) {

        String type = null;
        int randInt = new Random().nextInt(900000) + 100000;

        if (input.equals("current")) {
            type = "Cur";
        } else if (input.equals("savings")) {
            type = "Sav";
        }

        String generatedString = type + randInt;

        return generatedString;

    }

    public BankAcc viewAcc(List<BankAcc> blist, String acc_no) {

        BankAcc ba = new BankAcc();

        for(int i = 0; i < blist.size(); i++) {

            if(blist.get(i).getAcc_no().equals(acc_no)){
                ba = blist.get(i);
            }
        }
        return ba;
    }
}



