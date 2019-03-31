package com.qantas.calculator;

import org.junit.*;
import static org.junit.Assert.*;

public class DateCalculatorAppTest {

    DataCalculatorApp app = new DataCalculatorApp();
    @Test
    public void calculateDatesDifferenceWithSameYearSameMonthTest() {
        int days = app.calculateDatesDifference("1983-06-02","1983-06-22");
        assertEquals(19,days);
    }
    @Test
    public void calculateDatesDifferenceWithSameYearWithDiffMonthTest() {
        int days = app.calculateDatesDifference("1984-07-04","1984-12-25");
        assertEquals(173,days);
    }
    @Test
    public void calculateDatesDifferenceWithDifferentYearTest() {
        int days = app.calculateDatesDifference("1989-01-03","1983-08-03");
        assertEquals(1979,days);
    }
    @Test
    public void calculateDatesDifferenceWithZeroDayTest() {
        int days = app.calculateDatesDifference("1972-11-07","1972-11-08");
        assertEquals(0,days);
    }
    @Test
    public void calculateDatesDifferenceWithOneDayTest() {
        int days = app.calculateDatesDifference("2000-01-01","2000-01-03");
        assertEquals(1,days);
    }
}
