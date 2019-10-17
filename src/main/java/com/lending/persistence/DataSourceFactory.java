package com.lending.persistence;

import com.ibatis.common.jdbc.ScriptRunner;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class DataSourceFactory {

    private static final Logger LOG = Logger.getLogger(DataSourceFactory.class);

    private static final DataSourceFactory INSTANCE = new DataSourceFactory();

    private DataSourceFactory() {

    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    private static DataSource dataSource;

    static {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");

        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(url);
        mysqlDataSource.setUser(user);
        mysqlDataSource.setPassword(pass);

        dataSource = mysqlDataSource;
        LOG.info("Connected to DB");
    }

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            LOG.error("Couldn't get connection!");
        }

        return connection;
    }

    public static void connectToBanks() {
        Connection connection = null;
        try {
            connection = getConnection();

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

    public static void dropDB() {
        Connection connection = null;
        try {
            connection = getConnection();

            ScriptRunner scriptRunner = new ScriptRunner(
                    connection, false, false);

            Reader drop = new BufferedReader(
                    new FileReader("src/main/resources/sql/drop.sql"));
            scriptRunner.runScript(drop);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        LOG.info("Dropped DB");
    }
}
