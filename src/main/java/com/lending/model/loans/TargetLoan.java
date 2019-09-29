package com.lending.model.loans;

import com.lending.model.enums.LoanTarget;

import java.util.Set;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class TargetLoan extends Loan {

    private Set<LoanTarget> availableTargets;

    public Set<LoanTarget> getAvailableTargets() {
        return availableTargets;
    }

    public void setAvailableTargets(Set<LoanTarget> availableTargets) {
        this.availableTargets = availableTargets;
    }
}