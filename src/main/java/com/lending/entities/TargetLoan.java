package com.lending.entities;

import com.lending.service.UserViewService;

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
        return "►" + id + " Сумма кредита: " + loanSize +
                ", срок выплаты: " + UserViewService.convertLoanTermInDays(loanTermInDays) + ",\n" +
                "процентная ставка: " + loanInterest + "%" +
                ", досрочное погашение: " + UserViewService.convertEarlyPayment(earlyRepayment);
    }
}
