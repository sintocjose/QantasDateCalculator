package com.qantas.calculator;

import java.util.Objects;

/**
 * Class used for storing date values
 */
public class QantasDate implements Comparable<QantasDate> {
    int year;
    int month;
    int day;
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "QantasDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QantasDate that = (QantasDate) o;
        return year == that.year &&
                month == that.month &&
                day == that.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    public int compareTo(QantasDate date) {
        if(this.equals(date)){
            return 0;
        }
        if(this.getYear()>date.getYear()){
            return 1;
        }else if(this.getMonth()>date.getMonth()){
            return 1;
        }else if(this.getDay()>date.getDay()){
            return 1;
        }else {
            return -1;
        }
    }
}
