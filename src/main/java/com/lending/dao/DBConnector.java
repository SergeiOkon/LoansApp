package com.lending.dao;

import com.ibatis.common.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
@Component
public class DBConnector {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @Bean
//    public Connection getConnection() throws SQLException {
//        ResourceBundle resource = ResourceBundle.getBundle("database");
//        String url = resource.getString("db.url");
//        String user = resource.getString("db.user");
//        String pass = resource.getString("db.password");
//        return jdbcTemplate.get(url, user, pass);
//    }

    @Bean
    public void connectToBanks() {
        Connection connection = null;
        try {
//            connection = getConnection();

            ScriptRunner scriptRunner = new ScriptRunner(
                    connection, false, false);

            Reader create = new BufferedReader(
                    new FileReader("src/main/resources/sql/createDB.sql"));
            Reader fill = new BufferedReader(
                    new FileReader("src/main/resources/sql/fillDB.sql"));
            scriptRunner.runScript(create);
            scriptRunner.runScript(fill);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public void dropDB() {
        Connection connection = null;
        try {
//            connection = getConnection();

            ScriptRunner scriptRunner = new ScriptRunner(
                    connection, false, false);

            Reader drop = new BufferedReader(
                    new FileReader("src/main/resources/sql/drop.sql"));
            scriptRunner.runScript(drop);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}