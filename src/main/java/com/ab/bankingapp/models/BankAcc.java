package com.ab.bankingapp.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bank_acc")
@Inheritance(strategy = InheritanceType.JOINED)
public class BankAcc {

    @Id //  mySQL primary key
    @Column(name = "acc_no")
    private String acc_no;
    @Column(name = "bal")
    private double bal;
    @Column(name = "f_name")
    private String f_name;
    @Column(name = "l_name")
    private String l_name;
    @Transient
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    public BankAcc(String acc_no, double bal, String f_name, String l_name, LocalDate date) {
        this.acc_no = acc_no;
        this.bal = bal;
        this.f_name = f_name;
        this.l_name = l_name;
        this.date = date;
    }

    public BankAcc() {
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    public double getBal() {
        return bal;
    }

    public void setBal(double bal) {
        this.bal = bal;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
