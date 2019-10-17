package com.lending.service;

import com.lending.App;
import com.lending.dao.TargetLoanDao;
import com.lending.entities.TargetLoan;
import com.lending.entities.UserInfo;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class FilterService {

    private static final Logger LOG = Logger.getLogger(FilterService.class);

    private static TargetLoanDao targetLoanDao;
    private static UserInfo userInfo;

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[33m";
    private static final String ANSI_CYAN = "\u001B[35m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_LAGUNA = "\u001B[36m";

    private Scanner scanner = new Scanner(System.in);

    public FilterService() {
        targetLoanDao = new TargetLoanDao();
        userInfo = new UserInfo();
    }

    public String getUserInput() {
        return scanner.nextLine();
    }

    public void getUserTarget() {
        String userTarget = getUserInput();
        String target = "consumer";
        switch (userTarget) {
            case ("1"):
                target = "vehicle";
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (1) Покупка автомобиля----------------------\u23F9" + ANSI_GREEN);
                break;
            case ("2"):
                target = "real_estate";
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (2) Покупка недвижимости--------------------\u23F9" + ANSI_GREEN);
                break;
            case ("3"):
                target = "consumer";
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (3) Потребительский кредит------------------\u23F9" + ANSI_GREEN);
                break;
            case ("4"):
                target = "house_repairs";
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (4) Ремонт квартиры-------------------------\u23F9" + ANSI_GREEN);
                break;
            case ("5"):
                target = "business";
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (5) Открытие бизнеса------------------------\u23F9" + ANSI_GREEN);
                break;
            default:
                System.out.println(ANSI_RED + "\u23F9--Введите цель кредита заново:---------------------------\u23F9" + ANSI_RED);
                getUserTarget();
                break;
        }
        userInfo.setTarget(target);
        LOG.info("Waiting fot user`s target input");
    }

    public void getUserOccupation() {
        String userOccupation = getUserInput();
        String occupation = "temp_not_work";
        switch (userOccupation) {
            case "1":
                occupation = "work_officially";
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (1) Работаю---------------------------------\u23F9" + ANSI_GREEN);
                break;
            case ("2"):
                occupation = "temp_not_work";
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (2) Временно не работаю---------------------\u23F9" + ANSI_GREEN);
                break;
            case ("3"):
                occupation = "businessman";
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (3) Предприниматель-------------------------\u23F9" + ANSI_GREEN);
                break;
            case ("4"):
                occupation = "retiree";
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (4) Пенсионер-------------------------------\u23F9" + ANSI_GREEN);
                break;
            case ("5"):
                occupation = "student";
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (5) Студент---------------------------------\u23F9" + ANSI_GREEN);
                break;
            case ("6"):
                occupation = "maternity_leave";
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (6) Декретный отпуск------------------------\u23F9" + ANSI_GREEN);
                break;
            default:
                System.out.println(ANSI_RED + "\u23F9--Введите Ваш род деятельности заново:-------------------\u23F9" + ANSI_RED);
                getUserOccupation();
                break;
        }
        userInfo.setOccupation(occupation);

        LOG.info("Waiting fot user`s occupation input");
    }

    public void getUserCreditMenu() {
        String userInput = getUserInput();
        if (userInput.equals("x")) {
            LOG.info("Exiting the program");
            System.exit(0);
        } else if (userInput.equals("c")) {
            App.runApp();
        } else {
            if (TargetLoanDao.getLoans().containsKey(Integer.parseInt(userInput))) {
                System.out.println(ANSI_LAGUNA + "Вы выбрали:" + "\n" + ANSI_GREEN + TargetLoanDao.getLoans().get(Integer.parseInt(userInput)) + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "Введите снова:" + ANSI_RESET);
                getUserCreditMenu();
            }
        }
    }

    public void printLoansForUser() throws SQLException {

        TargetLoanDao.getAllBankNames();

        for (Map.Entry<Integer, String> entry : TargetLoanDao.getBankNames().entrySet()) {

            System.out.printf(ANSI_GREEN + entry.getValue() + "\n" + ANSI_RESET);

            targetLoanDao.getAvailableLoansByBank(userInfo, entry.getKey());

            for (Map.Entry<Integer, TargetLoan> loan : TargetLoanDao.getLoans().entrySet()) {
                if (loan.getValue().getBankId() == entry.getKey()) {
                    System.out.println(ANSI_CYAN + loan.getValue());
                }
            }
        }
    }

}
