package com.lending.factory;

import com.lending.model.banks.Bank;
import com.lending.model.banks.BankInfo;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public interface BankFactory {

    Bank getBank(BankInfo bankInfo);

}