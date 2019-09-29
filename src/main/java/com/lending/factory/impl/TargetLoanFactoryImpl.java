package com.lending.factory.impl;

import com.lending.factory.TargetLoanFactory;
import com.lending.model.loans.TargetLoan;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class TargetLoanFactoryImpl implements TargetLoanFactory {

    public TargetLoan getTargetLoan(TargetLoan loanInfo) {
        TargetLoan targetLoan = new TargetLoan();
        targetLoan.setLoanSize(loanInfo.getLoanSize());
        targetLoan.setLoanInterest(loanInfo.getLoanInterest());
        targetLoan.setLoanTermInDays(loanInfo.getLoanTermInDays());
        targetLoan.setEarlyRepayment(loanInfo.isEarlyRepayment());
        targetLoan.setAvailableOccupations(loanInfo.getAvailableOccupations());
        targetLoan.setAvailableTargets(loanInfo.getAvailableTargets());
        return targetLoan;
    }
}