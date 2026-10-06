/*
Author: Roy Lu
Date: October 6th, 2026
Description: Tests the Date class.
*/

public class DateTest {
    public static void main(String[] args) {
        Date myBirthday = new Date(6, 17, 2010);
        myBirthday.displayDate();

        System.out.println("Month: " + myBirthday.getMonth());
        System.out.println("Day: " + myBirthday.getDay());
        System.out.println("Year: " + myBirthday.getYear());

        myBirthday.setMonth(11);
        myBirthday.setDay(24);
        myBirthday.setYear(2012);

        myBirthday.displayDate();
    }
}
