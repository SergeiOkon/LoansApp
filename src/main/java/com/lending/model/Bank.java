package com.lending.model;

import com.lending.model.loans.Loan;
import com.lending.model.loans.TargetLoan;

import java.util.ArrayList;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class Bank {

    private String name;
    private ArrayList<Loan> loans = new ArrayList();

    public void addTargetLoan(TargetLoan tL) {
        loans.add(tL);
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }
}