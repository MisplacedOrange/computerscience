/*
Author: Roy Lu
Date: September 23rd, 2026
Description: Estimates the group size needed to see every birthday date by averaging repeated simulations.
*/

public class Q4 {
    private static final int DAYS_IN_YEAR = 365;

    public static void main(String[] args) {
        /*
        Purpose: Runs the birthday simulations and displays the results of one trial and the average.
        Parameters: Command line arguments are passed in, but are not used.
        Return Value: None.
        */

        int trials = 1000;

        System.out.println("People selected to see all 365 birthdays: " + countPeopleForAllBirthdays());
        System.out.println("Average over " + trials + " trials: " + averagePeopleForAllBirthdays(trials));
    }

    public static int countPeopleForAllBirthdays() {
        /*
        Purpose: Selects random birthdays until every day of the year has been seen.
        Parameters: None.
        Return Value: The number of people selected.
        */

        boolean[] birthdaysSeen = new boolean[DAYS_IN_YEAR];
        int uniqueBirthdays = 0;
        int peopleSelected = 0;

        while (uniqueBirthdays < DAYS_IN_YEAR) {
            int birthday = (int) (Math.random() * DAYS_IN_YEAR);
            peopleSelected++;

            if (!birthdaysSeen[birthday]) {
                birthdaysSeen[birthday] = true;
                uniqueBirthdays++;
            }
        }

        return peopleSelected;
    }

    public static double averagePeopleForAllBirthdays(int trials) {
        /*
        Purpose: Finds the average number of people needed to see every birthday across multiple trials.
        Parameters: trials (The number of simulations to run).
        Return Value: The average number of people selected.
        */

        long totalPeopleSelected = 0;

        for (int trial = 0; trial < trials; trial++) {
            totalPeopleSelected += countPeopleForAllBirthdays();
        }

        return (double) totalPeopleSelected / trials;
    }
}

