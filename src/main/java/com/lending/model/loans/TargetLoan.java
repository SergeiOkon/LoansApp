package com.lending.model.loans;

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

    private String convertEarlyPayment(boolean earlyRepayment) {
        if (earlyRepayment) {
            return "возможно";
        } else {
            return "не возможно";
        }
    }

    private String convertLoanTermInDays(int loanTermInDays) {
        if (loanTermInDays < 365) {
            return loanTermInDays + " дней";
        } else {
            return Double.toString((double) (loanTermInDays) / 365) + " год(a)";
        }
    }

    @Override
    public String toString() {
        return "►" + id + " Сумма кредита: " + loanSize +
                ", срок выплаты: " + convertLoanTermInDays(loanTermInDays) + ",\n" +
                "процентная ставка: " + loanInterest + "%" +
                ", досрочное погашение: " + convertEarlyPayment(earlyRepayment);
    }
}