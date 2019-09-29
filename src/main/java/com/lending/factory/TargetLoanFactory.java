package com.lending.factory;

import com.lending.model.loans.TargetLoan;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public interface TargetLoanFactory {

    TargetLoan getTargetLoan(TargetLoan loan);

}
