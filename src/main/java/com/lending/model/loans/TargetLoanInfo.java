package com.lending.model.loans;

import com.lending.model.enums.LoanTarget;
import com.lending.model.enums.Occupation;

import java.util.Set;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class TargetLoanInfo {
    private int loanSize;
    private int loanInterest;
    private int loanTermInDays;
    private boolean earlyRepayment;

    private Set<Occupation> availableOccupations;
    private Set<LoanTarget> availableTargets;

    public int getLoanSize() {
        return loanSize;
    }

    public void setLoanSize(int loanSize) {
        this.loanSize = loanSize;
    }

    public int getLoanInterest() {
        return loanInterest;
    }

    public void setLoanInterest(int loanInterest) {
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

    public Set<Occupation> getAvailableOccupations() {
        return availableOccupations;
    }

    public void setAvailableOccupations(Set<Occupation> availableOccupations) {
        this.availableOccupations = availableOccupations;
    }

    public Set<LoanTarget> getAvailableTargets() {
        return availableTargets;
    }

    public void setAvailableTargets(Set<LoanTarget> availableTargets) {
        this.availableTargets = availableTargets;
    }
}