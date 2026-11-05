/*
Author: Roy Lu
Last modified: November 5th, 2026
Description: Benchmarks heap sort using several array sizes and repeated trials.
*/

import java.util.Random;

/** Runs the heap sort timing exercise. */
public class Q1 {
    public static void main(String[] args) {
        /*
         * Runs timing trials for several array sizes.
         * Parameters: args contains command-line arguments (unused).
         * Returns: nothing.
         */
        int[] sizes = {100000, 200000, 400000};
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

            System.out.println("\nHeap sort: " + size + " numbers");
            for (int trial = 1; trial <= trials; trial++) {
                int[] data = original.clone();

                long start = System.currentTimeMillis();
                sortByHeap(data);
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

    public static void sortByHeap(int[] data) {
        /*
         * Sorts the supplied array in ascending order using heap sort.
         * Parameters: data is the array to sort in place.
         * Returns: nothing.
         */
        buildMaxHeap(data);

        // Move the largest remaining value to the end of the heap.
        for (int heapSize = data.length; heapSize > 1; heapSize--) {
            int temporaryValue = data[0];
            data[0] = data[heapSize - 1];
            data[heapSize - 1] = temporaryValue;

            restoreMaxHeap(data, heapSize - 1, 0);
        }
    }

    public static void buildMaxHeap(int[] data) {
        /*
         * Arranges the array into a max heap.
         * Parameters: data is the array to arrange in place.
         * Returns: nothing.
         */
        for (int index = data.length / 2 - 1; index >= 0; index--) {
            restoreMaxHeap(data, data.length, index);
        }
    }

    public static void restoreMaxHeap(int[] data, int heapSize, int root) {
        /*
         * Restores the max-heap property beneath a root.
         * Parameters: data is the heap array, heapSize is the active length, and root is the root index.
         * Returns: nothing.
         */
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < heapSize && data[left] > data[largest]) {
            largest = left;
        }
        if (right < heapSize && data[right] > data[largest]) {
            largest = right;
        }

        if (largest != root) {
            int temporaryValue = data[root];
            data[root] = data[largest];
            data[largest] = temporaryValue;

            restoreMaxHeap(data, heapSize, largest);
        }
    }
}
