package com.lending;

import com.lending.service.UserViewService;

import java.sql.SQLException;

import static com.lending.persistence.DataSourceFactory.connectToBanks;
import static com.lending.persistence.DataSourceFactory.dropDB;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        runApp();
    }

    public static void runApp() {
        UserViewService ui = new UserViewService();

        dropDB();
        connectToBanks();

        ui.greeting();
        ui.requestTarget();
        ui.requestOccupation();
        try {
            ui.showAvailableLoans();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ui.showSelectMenu();
    }
}
