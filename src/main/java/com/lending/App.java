package com.lending;

import com.lending.dao.DBConnector;
import com.lending.service.UserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
@Component
public class App {

    @Autowired
    private DBConnector db;

    @Autowired
    private UserViewService ui;

    @Bean
    public void runApp() {
        db.dropDB();
        ui.greeting();
        ui.requestTarget();
        ui.requestOccupation();
        try {
            ui.showAvailableLoans();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ui.showSelectMenu();
        System.exit(0);
    }
}
