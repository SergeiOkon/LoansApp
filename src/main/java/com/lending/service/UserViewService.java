package com.lending.service;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class UserViewService {
    private static final String ANSI_CYAN = "\u001B[36m";
    private FilterService filter = new FilterService();
    public void greeting() {
        System.out.println(ANSI_CYAN + "▲---------------------------------------------------------▲" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9----------------Вас приветствует LoansApp----------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--Мы предоставляем условия для удобного поиска кредитов--\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9------Для получения списков оптимальных предложений------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9-------------Выберете удобные для вас условия:-----------\u23F9" + ANSI_CYAN);

    }

    public void requestTarget() {
        System.out.println(ANSI_CYAN + "\u23F9---Цель кредита:-----------------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(1)Покупка автомобиля----------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(2)Покупка недвижимости--------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(3)Потребительский кредит(Мебель, бытовая техника)-----\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(4)Ремонт квартиры-------------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(5)Открытие бизнеса------------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--Введите цифру отвечающую вашему запросу:---------------\u23F9" + ANSI_CYAN);
        filter.getUserTarget();
    }
    public void requestOccupation() {
        System.out.println(ANSI_CYAN + "\u23F9---Род Вашей занятости:----------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(1)Работаю---------------------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(2)Временно не работаю---------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(3)Предприниматель-------------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(4)Пенсионер-------------------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(5)Студент---------------------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(5)Декретный отпуск------------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--Введите цифру отвечающую вашему запросу:---------------\u23F9" + ANSI_CYAN);
        filter.getUserOccupation();
    }
    public void showAvailableLoans() {

        filter.getAvailableLoans();
    }

}
/*
    WORK_OFFICIALLY,
    TEMPORARILY_NOT_WORK,
    BUSINESSMAN,
    RETIREE,
    STUDENT,
    MATERNITY_LEAVE

    public enum LoanTarget {
    VEHICLE,
    REAL_ESTATE,
    CONSUMER,
    HOUSE_REPAIRS,
    BUSINESS
}
 */