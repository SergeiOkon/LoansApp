package com.lending.model;

import com.lending.model.enums.Occupation;
import com.lending.model.loans.Loan;

import java.util.Map;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class User {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int salary;
    private Occupation occupation;

    private Map<String, Loan> userLoans;
}