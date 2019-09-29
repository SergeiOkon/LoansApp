package com.lending.service;

/**
 * Created by BOSSJNR on 28.09.2019.
 */
public class UserViewService {
    public static final String ANSI_CYAN = "\u001B[36m";

    public void greeting() {
        System.out.println(ANSI_CYAN + "▲---------------------------------------------------------▲" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9----------------Вас приветствует LoansApp----------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--Мы предоставляем условия для удобного поиска кредитов--\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9------Для получения списков оптимальных предложений------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9-------------Выберете удобные для вас условия:-----------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9---Цель кредита:-----------------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(1)Покупка автомобиля----------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(2)Покупка недвижимости--------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(3)Потребительский кредит(Мебель, бытовая техника)-----\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(4)Ремонт квартиры-------------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--(4)Открытие бизнеса------------------------------------\u23F9" + ANSI_CYAN);
        System.out.println(ANSI_CYAN + "\u23F9--Введите цифру отвечающую вашему запросу:---------------\u23F9" + ANSI_CYAN);

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