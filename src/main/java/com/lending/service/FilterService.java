package com.lending.service;

import com.lending.model.enums.LoanTarget;
import com.lending.model.enums.Occupation;

import java.util.Scanner;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class FilterService {
    private Occupation occupation;
    private String userOccupation;
    private LoanTarget target;
    private String userTarget = "0";
    private int loanSize;
    private int salary;

    Scanner scanner = new Scanner(System.in);

    public void getUserTarget() {
        userTarget = scanner.nextLine();
        switch (userTarget) {
            case "1":
                target = LoanTarget.VEHICLE;
                break;
            case ("2"):
                target = LoanTarget.REAL_ESTATE;
                break;
            case ("3"):
                target = LoanTarget.CONSUMER;
                break;
            case ("4"):
                target = LoanTarget.HOUSE_REPAIRS;
                break;
            case ("5"):
                target = LoanTarget.BUSINESS;
                break;
            default:
                System.out.println("Введите цель кредита заново:");
                getUserTarget();
                break;
        }
    }
}