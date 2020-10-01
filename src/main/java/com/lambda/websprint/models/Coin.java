package com.lambda.websprint.models;

import javax.persistence.*;

@Entity
@Table(name = "coins")

public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long coinid;
    String name;
    String namepural;
    double value;
    long quantity;


    public Coin(String name, String namepural, double value, long quantity) {
        this.name = name;
        this.namepural = namepural;
        this.value = value;
        this.quantity = quantity;
    }

    public Coin()
    {
        // default constructor is required by Spring Data JPA
    }

    public long getCoinid() {
        return coinid;
    }

    public void setEmpid(long coinid) {
        this.coinid = coinid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameplural() {
        return namepural;
    }

    public void setNameplural(String nameplural) {
        this.namepural = nameplural;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "coinid=" + coinid +
                ", name='" + name + '\'' +
                ", nameplural='" + namepural + '\'' +
                ", value=" + value +
                ", quantity=" + quantity +
                '}';
    }
}
