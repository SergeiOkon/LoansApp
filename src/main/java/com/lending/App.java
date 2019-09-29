package com.lending;

import com.lending.dao.DBConnector;
import com.lending.service.FilterService;
import com.lending.service.UserViewService;

import java.io.File;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        runApp();
    }

    static void runApp() {
        DBConnector db = new DBConnector();
        UserViewService ui = new UserViewService();
        FilterService filter = new FilterService();

        db.dropDB();
        db.connectToBanks();
        ui.greeting();
        filter.getUserTarget();
    }
}