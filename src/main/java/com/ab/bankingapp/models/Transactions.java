package com.ab.bankingapp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transactions {


//    @ManyToOne
    @JoinColumn(name = "acc_no")
    private String acc_no;

    public enum Type {
        DEPOSIT, WITHDRAW, OPENBAL, REVERSAL
    }

    @Id //  mySQL primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtransactions")
    private int tranID;
    @Column(name = "amount")
    private double amount;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 5)
    private Type type;
    @Column(name = "bal")
    private double bal;
    @Transient
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    //    public BankAcc getBankAcc() {
//        return bankAcc;
//    }
//
//    public void setBankAcc(BankAcc bankAcc) {
//        this.bankAcc = bankAcc;
//    }

    public Transactions(String acc_no, double amount, Type type, double bal, LocalDate date) {
        this.amount = amount;
        this.type = type;
        this.bal = bal;
        this.date = date;
    }

    public Transactions() {
    }

    public int getTranID() {
        return tranID;
    }

    public void setTranID(int tranID) {
        this.tranID = tranID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getBal() {
        return bal;
    }

    public void setBal(double bal) {
        this.bal = bal;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
