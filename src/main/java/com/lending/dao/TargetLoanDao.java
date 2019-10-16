package com.lending.dao;

import com.lending.entities.TargetLoan;
import com.lending.persistence.DataSourceFactory;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;

public class TargetLoanDao {

    private static final Logger LOG = Logger.getLogger(DataSourceFactory.class);

    private DataSource dataSource = DataSourceFactory.getDataSource();



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
}