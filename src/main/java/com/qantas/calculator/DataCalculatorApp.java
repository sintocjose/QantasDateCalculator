package com.qantas.calculator;

import java.util.Scanner;

/**
 * This class is the main class for running this Date Calculator Application.
 * App calculates the number of days between two days without using Java Date library functionalities.
 */
public class DataCalculatorApp {

    public static String HIPHEN = "-";
    public static int DAYS_IN_YEAR = 365;
    public static int DAYS_IN_LEAPYEAR = 366;
    public static int DAYS_IN_MONTH[] = {31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31};
    public static int DAYS_IN_MONTH_LEAP_YEAR[] = {31, 29, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31};

    /**
     * Convert String into Qantas Date object and call the calculateDays method for getting the number of days between the dates.
     *
     * @param date1
     * @param date2
     * @return
     */
    public int calculateDatesDifference(String date1, String date2) {
        String[] date1Elements = date1.split(HIPHEN);
        QantasDate qantdate1 = CalculatorUtils.createQantasDateFromElements(date1Elements);
        String[] date2Elements = date2.split(HIPHEN);
        QantasDate qantdate2 = CalculatorUtils.createQantasDateFromElements(date2Elements);
        if (qantdate1.equals(qantdate2)) {
            return 0;
        }
        if (qantdate1.compareTo(qantdate2) > 0) {
            return calculateDays(qantdate1, qantdate2);
        } else {
            return calculateDays(qantdate2, qantdate1);
        }
    }

    /**
     * Method calculates the difference between dates
     *
     * @param greater
     * @param smaller
     * @return
     */
    private int calculateDays(QantasDate greater, QantasDate smaller) {
        int numOfDays = 0;
        for (int i = smaller.getYear(); i < greater.year; i++) {
            if (i != smaller.getYear()) {
                if (CalculatorUtils.isLeapYear(i)) {
                    numOfDays += DAYS_IN_LEAPYEAR;
                } else {
                    numOfDays += DAYS_IN_YEAR;
                }
            }
        }
        if (smaller.year == greater.year) {
            numOfDays += (numberOfDays(greater) - numberOfDays(smaller) - 1);
        } else {
            numOfDays += (numberOfDaysForStartingYear(smaller) + numberOfDays(greater) - 1);
        }
        return numOfDays;
    }

    /**
     * Calculates number of days are there from the beginning of a particular year.
     *
     * @param date
     * @return
     */
    private int numberOfDays(QantasDate date) {
        int days = 0;
        for (int i = 0; i < date.getMonth() - 1; i++) {
            if (CalculatorUtils.isLeapYear(date.getYear())) {
                days += DAYS_IN_MONTH_LEAP_YEAR[i];
            } else {
                days += DAYS_IN_MONTH[i];
            }
        }
        days += date.getDay();
        return days;
    }

    /**
     * Calculates number of days exist from the beginning of the date till the end of a particular year.
     *
     * @param date
     * @return
     */
    private int numberOfDaysForStartingYear(QantasDate date) {
        int days = 0;
        for (int i = date.getMonth(); i < 12; i++) {
            if (CalculatorUtils.isLeapYear(date.getYear())) {
                days += DAYS_IN_MONTH_LEAP_YEAR[i];
            } else {
                days += DAYS_IN_MONTH[i];
            }
        }
        if (CalculatorUtils.isLeapYear(date.getYear())) {
            days += (DAYS_IN_MONTH_LEAP_YEAR[date.getMonth() - 1] - date.getDay());
        } else {
            days += (DAYS_IN_MONTH[date.getMonth() - 1] - date.getDay());
        }
        return days;
    }

    /**
     * Starting method for Date Calculator App
     *
     * @param args
     */
    public static void main(String[] args) {
        DataCalculatorApp app = new DataCalculatorApp();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the First Date in Years-MM-DD format");
        String date1 = scanner.nextLine();
        if (!CalculatorUtils.validateDateFormat(date1)) {
            throw new QantasCustomException("Invalid Date format");
        }
        System.out.println("Please enter the Second Date in Years-MM-DD format");
        String date2 = scanner.nextLine();
        if (!CalculatorUtils.validateDateFormat(date2)) {
            throw new QantasCustomException("Invalid Date format");
        }
        System.out.println("Number of Days between those dates = " + app.calculateDatesDifference(date1, date2));
    }
}
