package com.lending.model.banks;

import com.lending.model.loans.TargetLoan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BOSSJNR on 28.09.2019.
 */

public class Bank {

    private int bankId;
    private String name;
    private List<TargetLoan> loans = new ArrayList<>();


    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TargetLoan> getLoans() {
        return loans;
    }

    public void setLoans(List<TargetLoan> loans) {
        this.loans = loans;
    }
}