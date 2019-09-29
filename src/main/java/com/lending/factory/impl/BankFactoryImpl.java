package com.lending.factory.impl;

import com.lending.factory.BankFactory;
import com.lending.model.banks.Bank;
import com.lending.model.banks.BankInfo;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class BankFactoryImpl implements BankFactory {

    public Bank getBank(BankInfo bankInfo) {
        Bank bank = new Bank();
        bank.setLoans(bankInfo.getLoans());
        bank.setName(bankInfo.getName());
        return bank;
    }
}