package com.lending.model.loans;

import com.lending.dao.DBConnector;
import com.lending.model.banks.Bank;
import com.lending.model.enums.LoanTarget;
import com.lending.model.enums.Occupation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class TargetLoan {
    private int bankId;
    private int loanSize;
    private int loanTermInDays;
    private static int bankCount;
    private double loanInterest;
    private boolean earlyRepayment;

    private List<Bank> banks = new ArrayList<>();
    private List<Occupation> availableOccupations = new ArrayList<>();
    private List<LoanTarget> availableTargets = new ArrayList<>();

    public void formLoans() throws SQLException {
        String loanQuery = "select ofBank, size, interest, termInDays, earlyRepaiment from loans";
        String bankQuery = "select name from banks";

        DBConnector db = new DBConnector();
        Connection connection = db.getConnection();
        Statement statement = connection.createStatement();

        ResultSet bankSet = statement.executeQuery(bankQuery);

        while (bankSet.next()) {
            Bank bank = new Bank();
            bank.setName(bankSet.getString(1));
            System.out.println(bank.getName());
            bankCount++;
            banks.add(bank);
        }

        ResultSet loanSet = statement.executeQuery(loanQuery);
        while (loanSet.next()) {
            List<TargetLoan> loans = new ArrayList<>();
            for (int i = 0; i < bankCount; i++) {
                TargetLoan targetLoan = new TargetLoan();
                targetLoan.setBankId(loanSet.getInt(1));
                targetLoan.setLoanSize(loanSet.getInt(2));
                targetLoan.setLoanInterest(loanSet.getDouble(3));
                targetLoan.setLoanTermInDays(loanSet.getInt(4));
                targetLoan.setEarlyRepayment(loanSet.getBoolean(5));
                loans.add(targetLoan);
            }
            banks.get(loanSet.getInt(1)-1).setLoans(loans);
        }
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getLoanSize() {
        return loanSize;
    }

    public void setLoanSize(int loanSize) {
        this.loanSize = loanSize;
    }

    public double getLoanInterest() {
        return loanInterest;
    }

    public void setLoanInterest(double loanInterest) {
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

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    public List<Occupation> getAvailableOccupations() {
        return availableOccupations;
    }

    public void setAvailableOccupations(List<Occupation> availableOccupations) {
        this.availableOccupations = availableOccupations;
    }

    public List<LoanTarget> getAvailableTargets() {
        return availableTargets;
    }

    public void setAvailableTargets(List<LoanTarget> availableTargets) {
        this.availableTargets = availableTargets;
    }

    @Override
    public String toString() {
        return "TargetLoan{" +
                "bankId=" + bankId +
                ", loanSize=" + loanSize +
                ", loanTermInDays=" + loanTermInDays +
                ", loanInterest=" + loanInterest +
                ", earlyRepayment=" + earlyRepayment +
                '}';
    }
}