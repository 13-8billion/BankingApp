package com.ab.bankingapp.models;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "current_acc")
@Component
public class CurrentAcc extends BankAcc{

    @Column(name = "overdraft_limit")
    private double overdraftLimit;
    @OneToMany(targetEntity=Transactions.class, mappedBy="acc_no", fetch=FetchType.EAGER)
    @Column(name = "t_history")
    private List<Transactions> history;

    public CurrentAcc(String acc_no, double bal, String fName, String lName, LocalDate date, double overdraftLimit, List<Transactions> history) {
        super(acc_no, bal, fName, lName, date);
        this.overdraftLimit = overdraftLimit;
        this.history = history;
    }

    public CurrentAcc(double overdraftLimit, List<Transactions> history) {
        this.overdraftLimit = overdraftLimit;
        this.history = history;
    }

    public CurrentAcc() {
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public List<Transactions> getHistory() {
        return history;
    }

    public void setHistory(List<Transactions> history) {
        this.history = history;
    }
}
