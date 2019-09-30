package com.lending.service;

import com.lending.App;
import com.lending.dao.DBConnector;
import com.lending.model.loans.TargetLoan;

import java.sql.*;
import java.util.*;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class FilterService {
    private String userOccupation;
    private String occupation;
    private String userTarget;
    private String target;
    private List<String> bankNames = new ArrayList<>();
    private Map<Integer, TargetLoan> loans = new TreeMap<>();
    static int bankCount;
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[33m";
    private static final String ANSI_CYAN = "\u001B[35m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_LAGUNA = "\u001B[36m";

    Scanner scanner = new Scanner(System.in);

    public void getUserTarget() {
        userTarget = scanner.nextLine();
        switch (userTarget) {
            case "1":
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
    }

    public void getUserOccupation() {
        userOccupation = scanner.nextLine();
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
    }

    public void getUserCreditMenu() {
        String userInput = scanner.nextLine();
        if (userInput.equals("x")) {
            System.exit(0);
        } else if (userInput.equals("c")) {
            App.runApp();
            return;
        } else {
            if (loans.containsKey(Integer.parseInt(userInput))) {
                System.out.println(ANSI_LAGUNA + "Вы выбрали:" + "\n" + ANSI_GREEN + loans.get(Integer.parseInt(userInput)) + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "Введите снова:" + ANSI_RESET);
                getUserCreditMenu();
            }
        }
    }

    public void printLoansForUser() throws SQLException {
        String bankQuery = "select name from banks";

        DBConnector db = new DBConnector();
        Connection connection = db.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(bankQuery);
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            bankNames.add(name);
            System.out.printf(ANSI_GREEN + name + "\n" + ANSI_RESET);

            for (bankCount = 1; bankCount < bankNames.size() + 1; bankCount++) {
                PreparedStatement preparedStatement = connection.prepareStatement("select id, ofBank, size, interest, termInDays, earlyRepaiment from loans WHERE " + occupation + " = 1 AND " + target + " = 1");
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
            }
            printLoansByBank();
        }
    }

    private void printLoansByBank() {
        for (Map.Entry<Integer, TargetLoan> entry : loans.entrySet()) {
            if (bankNames.size() == entry.getValue().getBankId()) {
                System.out.println(ANSI_CYAN + entry.getValue());
            }
        }
    }
}