package com.lending.dao;

import com.lending.entities.TargetLoan;
import com.lending.entities.UserInfo;
import com.lending.persistence.DataSourceFactory;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class TargetLoanDao {

    private static final Logger LOG = Logger.getLogger(DataSourceFactory.class);

    private static DataSource dataSource = DataSourceFactory.getDataSource();

    private static Map<Integer, TargetLoan> loans = new TreeMap<>();
    private static Map<Integer, String> bankNames = new TreeMap<>();

    public TargetLoan getById(int id) {
        TargetLoan targetLoan = new TargetLoan();
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet loanSet = statement.executeQuery("SELECT * FROM loans WHERE id =" + id + ";");
            while (loanSet.next()) {
                targetLoan.setId(loanSet.getInt(1));
                targetLoan.setBankId(loanSet.getInt(2));
                targetLoan.setLoanSize(loanSet.getInt(3));
                targetLoan.setLoanInterest(loanSet.getDouble(4));
                targetLoan.setLoanTermInDays(loanSet.getInt(5));
                targetLoan.setEarlyRepayment(loanSet.getBoolean(6));
            }
        } catch (SQLException e) {
            LOG.error("Error while working with DataSource");
        }
        return targetLoan;
    }

    public Map<Integer, TargetLoan> getAvailableLoansByBank(UserInfo userInfo, int bankId) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select id, ofBank, size, interest, termInDays, earlyRepaiment from loans WHERE " + userInfo.getOccupation() + " = 1 AND " + userInfo.getTarget() + " = 1 AND ofBank = " + bankId);
            ResultSet loanSet = preparedStatement.executeQuery();

            while (loanSet.next()) {
                TargetLoan targetLoan = new TargetLoan();
                targetLoan.setId(loanSet.getInt(1));
                targetLoan.setBankId(loanSet.getInt(2));
                targetLoan.setLoanSize(loanSet.getInt(3));
                targetLoan.setLoanInterest(loanSet.getDouble(4));
                targetLoan.setLoanTermInDays(loanSet.getInt(5));
                targetLoan.setEarlyRepayment(loanSet.getBoolean(6));
                loans.put(targetLoan.getId(), targetLoan);
            }

        } catch (SQLException e) {
            LOG.error("Error while working with DataSource");
        }

        return loans;
    }

    public static Map<Integer, String> getAllBankNames() {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet bankSet = statement.executeQuery("select id, name from banks");

            while (bankSet.next()) {
                bankNames.put(bankSet.getInt("id"), bankSet.getString("name"));
            }

        } catch (SQLException e) {
            LOG.error("Error while working with DataSource");
        }
        return bankNames;
    }

    public static Map<Integer, String> getBankNames() {
        return bankNames;
    }

    public static Map<Integer, TargetLoan> getLoans() {
        return loans;
    }
}
