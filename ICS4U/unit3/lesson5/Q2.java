/*
Author: Roy Lu
Last modified: November 5th, 2026
Description: Benchmarks selection sort using several array sizes and repeated trials.
*/

import java.util.Random;

/** Runs the selection sort timing exercise. */
public class Q2 {
    public static void main(String[] args) {
        /*
         * Runs timing trials for several array sizes.
         * Parameters: args contains command-line arguments (unused).
         * Returns: nothing.
         */
        int[] sizes = {5000, 10000, 20000};
        int trials = 7;
        Random generator = new Random();

        for (int size : sizes) {
            int[] original = new int[size];
            for (int index = 0; index < original.length; index++) {
                original[index] = generator.nextInt(100000);
            }

            long total = 0;
            long fastest = Long.MAX_VALUE;
            long slowest = Long.MIN_VALUE;

            System.out.println("\nSelection sort: " + size + " numbers");
            for (int trial = 1; trial <= trials; trial++) {
                int[] data = original.clone();

                long start = System.currentTimeMillis();
                sortBySelection(data);
                long end = System.currentTimeMillis();

                long elapsed = end - start;
                total += elapsed;
                fastest = Math.min(fastest, elapsed);
                slowest = Math.max(slowest, elapsed);
                System.out.println("Trial " + trial + ": " + elapsed + " ms");
            }

            double average = (double) (total - fastest - slowest) / (trials - 2);
            System.out.println("Discarded fastest: " + fastest + " ms");
            System.out.println("Discarded slowest: " + slowest + " ms");
            System.out.printf("Average of remaining five trials: %.2f ms%n", average);
        }
    }

    public static void sortBySelection(int[] data) {
        /*
         * Sorts the supplied array in ascending order using selection sort.
         * Parameters: data is the array to sort in place.
         * Returns: nothing.
         */
        for (int index = 0; index < data.length - 1; index++) {
            // Find the smallest value in the unsorted portion.
            int smallest = index;
    
            for (int candidateIndex = index + 1; candidateIndex < data.length; candidateIndex++) {
                if (data[candidateIndex] < data[smallest]) {
                    smallest = candidateIndex;
                }
            }

            int temporaryValue = data[index];
            data[index] = data[smallest];
            data[smallest] = temporaryValue;
        }
    }
}
