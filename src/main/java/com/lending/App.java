package com.lending;

import com.lending.dao.DBConnector;

import java.io.File;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        runApp();
    }

    static void runApp() {
        System.out.println(new File(".").getAbsolutePath());
        DBConnector db = new DBConnector();
        db.dropDB();
        db.connectToBanks();
    }
}