package com.learning.cli.models;


import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import java.sql.Date;

public class Expense {
    @CsvBindByName(column = "ID")
//    @CsvBindByPosition(position = 0)
    private int id;

    @CsvBindByName(column = "DATE")
//    @CsvBindByPosition(position = 1)
    @CsvDate("dd/MM/yyyy")
    private Date date;

    @CsvBindByName(column = "DESCRIPTION")
//    @CsvBindByPosition(position = 3)
    private String description;

    @CsvBindByName(column = "AMOUNT")
//    @CsvBindByPosition(position = 2)
    private double amount;

    public Expense(int id, Date date, String description, double amount) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
