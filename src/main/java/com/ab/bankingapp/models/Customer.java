package com.ab.bankingapp.models;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id //  mySQL primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcustomer")
    private int custID;
    @Column(name = "f_name")
    private String f_name;
    @Column(name = "l_name")
    private String l_name;
    @Column(name = "email")
    private String email;

    public Customer(String f_name, String l_name, String email) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
    }

    public Customer() {
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
