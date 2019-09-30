package com.lending;

import com.lending.dao.DBConnector;
import com.lending.service.UserViewService;

import java.sql.SQLException;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        runApp();
    }

    public static void runApp() {
        DBConnector db = new DBConnector();
        UserViewService ui = new UserViewService();

        db.dropDB();
        db.connectToBanks();
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