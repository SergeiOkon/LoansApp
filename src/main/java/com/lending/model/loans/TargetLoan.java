package com.lending.model.loans;

import com.lending.dao.DBConnector;
import com.lending.model.banks.Bank;
import com.lending.model.enums.LoanTarget;
import com.lending.model.enums.Occupation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class TargetLoan {
    private int id;
    private int bankId;
    private int loanSize;
    private int loanTermInDays;
    private double loanInterest;
    private boolean earlyRepayment;

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoanSize() {
        return loanSize;
    }

    public void setLoanSize(int loanSize) {
        this.loanSize = loanSize;
    }

    public double getLoanInterest() {
        return loanInterest;
    }

    public void setLoanInterest(double loanInterest) {
        this.loanInterest = loanInterest;
    }

    public int getLoanTermInDays() {
        return loanTermInDays;
    }

    public void setLoanTermInDays(int loanTermInDays) {
        this.loanTermInDays = loanTermInDays;
    }

    public boolean isEarlyRepayment() {
        return earlyRepayment;
    }

    public void setEarlyRepayment(boolean earlyRepayment) {
        this.earlyRepayment = earlyRepayment;
    }

    @Override
    public String toString() {
        return  " loanSize=" + loanSize +
                ", loanTermInDays=" + loanTermInDays +
                ", loanInterest=" + loanInterest +
                ", earlyRepayment=" + earlyRepayment;
    }
}