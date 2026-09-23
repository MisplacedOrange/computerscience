/*
Author: Roy Lu
Date: September 23rd, 2026
Description: Simulates birthdays until one date has been selected three times.
*/

public class Q2 {
    private static final int DAYS_IN_YEAR = 365;

    public static void main(String[] args) {
        /*
        Purpose: Runs the birthday simulation and displays how many people were selected.
        Parameters: Command line arguments are passed in, but are not used.
        Return Value: None.
        */

        System.out.println("People selected until three share a birthday: " + birthDayCalculator());
    }

    public static int birthDayCalculator() {
        /*
        Purpose: Selects random birthdays until three people share the same birthday.
        Parameters: None.
        Return Value: The number of people selected.
        */

        int[] birthdayCounts = new int[DAYS_IN_YEAR];
        int peopleSelected = 0;

        while (true) {
            int birthday = (int) (Math.random() * DAYS_IN_YEAR);
            birthdayCounts[birthday]++;
            peopleSelected++;

            if (birthdayCounts[birthday] == 3) {
                return peopleSelected;
            }
        }
    }
}

