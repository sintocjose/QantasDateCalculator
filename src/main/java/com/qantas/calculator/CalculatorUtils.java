package com.qantas.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is a util class for Date Calculator Application
 */
public class CalculatorUtils {

    private static String regex = "^(?:[0-9]{2})?[0-9]?[0-9]-[0-3]?[0-9]-[0-3]?[0-9]$";

    /**
     * Method validates the date using regular expression
     * @param date
     * @return
     */
    public static boolean validateDateFormat(String date){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    /**
     * This method create a Qantas Date object from the string element
     * @param elements
     * @return
     */
    public static QantasDate createQantasDateFromElements(String[] elements){
        QantasDate date = new QantasDate();
        date.setYear(Integer.parseInt(elements[0]));
        date.setMonth(Integer.parseInt(elements[1]));
        date.setDay(Integer.parseInt(elements[2]));
        return date;
    }

    /**
     * Check whether a particular year is leap year or not
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
