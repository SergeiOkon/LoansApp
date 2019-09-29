package com.lending.factory.impl;

import com.lending.factory.LoanFactory;
import com.lending.model.loans.TargetLoan;
import com.lending.model.loans.TargetLoanInfo;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class LoanFactoryImpl implements LoanFactory {

    public TargetLoan getTargetLoan(TargetLoanInfo loanInfo) {
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