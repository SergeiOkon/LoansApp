package com.lending.factory;

import com.lending.model.loans.TargetLoan;
import com.lending.model.loans.TargetLoanInfo;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public interface LoanFactory {

    TargetLoan getTargetLoan(TargetLoanInfo loan);

}
