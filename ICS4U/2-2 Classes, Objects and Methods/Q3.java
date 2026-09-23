/*
Author: Roy Lu
Date: September 23rd, 2026
Description: Counts how many distinct birthday dates appear in a group of 365 people.
*/

public class Q3 {
    private static final int DAYS_IN_YEAR = 365;
    private static final int GROUP_SIZE = 365;

    public static void main(String[] args) {
        /*
        Purpose: Runs the birthday simulation and displays the number of unique birthdays.
        Parameters: Command line arguments are passed in, but are not used.
        Return Value: None.
        */

        System.out.println("Unique birthdays among 365 people: " + countUniqueBirthdays());
    }

    public static int countUniqueBirthdays() {
        /*
        Purpose: Counts the unique birthdays among a group of randomly selected birthdays.
        Parameters: None.
        Return Value: The number of unique birthdays selected.
        */

        boolean[] birthdaysSeen = new boolean[DAYS_IN_YEAR];
        int uniqueBirthdays = 0;

        for (int person = 0; person < GROUP_SIZE; person++) {
            int birthday = (int) (Math.random() * DAYS_IN_YEAR);

            if (!birthdaysSeen[birthday]) {
                birthdaysSeen[birthday] = true;
                uniqueBirthdays++;
            }
        }

        return uniqueBirthdays;
    }
}

