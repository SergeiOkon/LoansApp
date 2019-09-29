package com.lending.model.banks;

import com.lending.model.loans.Loan;
import com.lending.model.loans.TargetLoan;

import java.util.ArrayList;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class BankInfo {
    private String name;
    private ArrayList<Loan> loans = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTargetLoan(TargetLoan tL) {
        loans.add(tL);
    }

    public void setLoans(ArrayList<Loan> loans) {
        this.loans = loans;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }


}