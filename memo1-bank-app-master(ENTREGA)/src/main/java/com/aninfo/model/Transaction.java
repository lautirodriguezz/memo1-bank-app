package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long cbu;
    private Double ammount;
    private String typeTransaction;

    public Transaction(){
    }

    public Transaction(Long cbu, Double sum, String type) {
        this.cbu = cbu;
        this.ammount = sum;
        this.typeTransaction = type;
    }

    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }

    public Double getAmmount(){
        return ammount;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public String getTypeTransaction(){
        return typeTransaction;
    }

    public void setCBU(Long cbu) {
        this.cbu = cbu;
    }

    public Long getCbu() {
        return cbu;
    }

    public Long getID(){
        return id;
    }
}
