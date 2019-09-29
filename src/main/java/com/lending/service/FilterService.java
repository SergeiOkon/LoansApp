package com.lending.service;

import com.lending.dao.DBConnector;
import com.lending.model.loans.TargetLoan;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class FilterService {
    private String userOccupation;
    private int target;
    private String userTarget;
    private int occupation;
    private List<String> bankNames = new ArrayList<>();
    private Map<Integer, TargetLoan> loans = new TreeMap<>();
    static int bankCount;
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[33m";

    Scanner scanner = new Scanner(System.in);

    public void getUserTarget() {
        userTarget = scanner.nextLine();
        switch (userTarget) {
            case "1":
                target = 1;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (1) Покупка автомобиля----------------------\u23F9" + ANSI_GREEN);
                break;
            case ("2"):
                target = 2;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (2) Покупка недвижимости--------------------\u23F9" + ANSI_GREEN);
                break;
            case ("3"):
                target = 3;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (3) Потребительский кредит------------------\u23F9" + ANSI_GREEN);
                break;
            case ("4"):
                target = 4;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (4) Ремонт квартиры-------------------------\u23F9" + ANSI_GREEN);
                break;
            case ("5"):
                target = 5;
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
                occupation = 1;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (1) Работаю---------------------------------\u23F9" + ANSI_GREEN);
                break;
            case ("2"):
                occupation = 2;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (2) Временно не работаю---------------------\u23F9" + ANSI_GREEN);
                break;
            case ("3"):
                occupation = 3;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (3) Предприниматель-------------------------\u23F9" + ANSI_GREEN);
                break;
            case ("4"):
                occupation = 4;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (4) Пенсионер-------------------------------\u23F9" + ANSI_GREEN);
                break;
            case ("5"):
                occupation = 5;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (5) Студент---------------------------------\u23F9" + ANSI_GREEN);
                break;
            case ("6"):
                occupation = 6;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (6) Декретный отпуск------------------------\u23F9" + ANSI_GREEN);
                break;
            default:
                System.out.println(ANSI_RED + "\u23F9--Введите Ваш род деятельности заново:-------------------\u23F9" + ANSI_RED);
                getUserOccupation();
                break;
        }
    }

    public void getAvailableLoans() throws SQLException {

        String bankQuery = "select name from banks";

        DBConnector db = new DBConnector();
        Connection connection = db.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(bankQuery);
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            bankNames.add(name);
            System.out.printf("\u001B[34m" + "%s \n", name);

            for (bankCount = 1; bankCount < bankNames.size() + 1; bankCount++) {
                PreparedStatement preparedStatement = connection.prepareStatement("select id, ofBank, size, interest, termInDays, earlyRepaiment from loans WHERE ofBank = ?");
                preparedStatement.setInt(1, bankCount);

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

    private void printLoansForUser() throws SQLException {
        DBConnector db = new DBConnector();
        Connection connection = db.getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection
                .prepareStatement("select ?, ? from loans WHERE ? = 1 AND ? = 1"); // 1 - 1 ответ юзера 2 - второй ответ юзера 3 - 1 ответ юзера 4- 2 ответ юзера
        //TODO: сделать персональный запрос в DB и вывод пользователю
    }

    private void printLoansByBank() {
        for (Map.Entry<Integer, TargetLoan> entry : loans.entrySet()) {
            if (bankNames.size() == entry.getValue().getBankId()) {
                System.out.println(entry.getValue());
            }
        }
    }
}

//    private Occupation occupation;
//    private String userOccupation;
//    private LoanTarget target;
//    private String userTarget;