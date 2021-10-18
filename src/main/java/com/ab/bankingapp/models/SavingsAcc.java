package com.ab.bankingapp.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "savings_acc")
@Component
public class SavingsAcc extends BankAcc{

    @Column(name = "interest")
    private double interest;
    @OneToMany
    @Column(name = "t_history")
    private List<Transactions> history;


    public SavingsAcc(String acc_no, double bal, String fName, String lName, LocalDate date, double interest, List<Transactions> history) {
        super(acc_no, bal, fName, lName, date);
        this.interest = interest;
        this.history = history;
    }

    public SavingsAcc(double interest, List<Transactions> history) {
        this.interest = interest;
        this.history = history;
    }

    public SavingsAcc() {
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public List<Transactions> getHistory() {
        return history;
    }

    public void setHistory(List<Transactions> history) {
        this.history = history;
    }
}
