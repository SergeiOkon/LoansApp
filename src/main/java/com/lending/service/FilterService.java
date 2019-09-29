package com.lending.service;

import com.lending.model.enums.LoanTarget;
import com.lending.model.enums.Occupation;

import java.util.Scanner;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class FilterService {
    private Occupation occupation;
    private String userOccupation;
    private LoanTarget target;
    private String userTarget = "0";

    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[33m";


    Scanner scanner = new Scanner(System.in);

    public void getUserTarget() {
        userTarget = scanner.nextLine();
        switch (userTarget) {
            case "1":
                target = LoanTarget.VEHICLE;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (1) Покупка автомобиля----------------------\u23F9" + ANSI_GREEN);
                break;
            case ("2"):
                target = LoanTarget.REAL_ESTATE;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (2) Покупка недвижимости--------------------\u23F9" + ANSI_GREEN);
                break;
            case ("3"):
                target = LoanTarget.CONSUMER;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (3) Потребительский кредит------------------\u23F9" + ANSI_GREEN);
                break;
            case ("4"):
                target = LoanTarget.HOUSE_REPAIRS;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (4) Ремонт квартиры-------------------------\u23F9" + ANSI_GREEN);
                break;
            case ("5"):
                target = LoanTarget.BUSINESS;
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
                occupation = Occupation.WORK_OFFICIALLY;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (1) Работаю---------------------------------\u23F9" + ANSI_GREEN);
                break;
            case ("2"):
                occupation = Occupation.TEMPORARILY_NOT_WORK;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (2) Временно не работаю---------------------\u23F9" + ANSI_GREEN);
                break;
            case ("3"):
                occupation = Occupation.BUSINESSMAN;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (3) Предприниматель-------------------------\u23F9" + ANSI_GREEN);
                break;
            case ("4"):
                occupation = Occupation.RETIREE;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (4) Пенсионер-------------------------------\u23F9" + ANSI_GREEN);
                break;
            case ("5"):
                occupation = Occupation.STUDENT;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (5) Студент---------------------------------\u23F9" + ANSI_GREEN);
                break;
            case ("6"):
                occupation = Occupation.MATERNITY_LEAVE;
                System.out.println(ANSI_GREEN + "\u23F9--Вы выбрали (6) Декретный отпуск------------------------\u23F9" + ANSI_GREEN);
                break;
            default:
                System.out.println(ANSI_RED + "\u23F9--Введите Ваш род деятельности заново:-------------------\u23F9" + ANSI_RED);
                getUserOccupation();
                break;
        }
    }
    public void getAvailableLoans(){

    }
}