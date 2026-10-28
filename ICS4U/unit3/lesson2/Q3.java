/*
Author: Roy Lu
Date: October 28th, 2026
Description: Shows how Vector, HashSet, Hashtable, and HashMap handle common fruit records.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Vector;

public class Q3 {
    public static void main(String[] args) {
        Vector<String> fruits = new Vector<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple");
        System.out.println("Vector: " + fruits);
        System.out.println("Fruit at index 1: " + fruits.get(1));

        HashSet<String> uniqueFruits = new HashSet<>();
        uniqueFruits.add("Apple");
        uniqueFruits.add("Banana");
        boolean added = uniqueFruits.add("Apple");
        System.out.println("HashSet: " + uniqueFruits);
        System.out.println("Duplicate added: " + added);
        System.out.println("Contains Banana: " + uniqueFruits.contains("Banana"));

        Hashtable<String, Integer> fruitStock = new Hashtable<>();
        fruitStock.put("Apple", 10);
        fruitStock.put("Banana", 5);
        fruitStock.put("Apple", 12);
        System.out.println("Hashtable: " + fruitStock);
        System.out.println("Apple stock: " + fruitStock.get("Apple"));

        HashMap<String, Integer> fruitPrices = new HashMap<>();
        fruitPrices.put("Apple", 2);
        fruitPrices.put("Banana", 1);
        fruitPrices.put("Apple", 3);
        fruitPrices.put(null, 0);
        fruitPrices.put("Mango", null);
        System.out.println("HashMap: " + fruitPrices);
        System.out.println("Apple price: " + fruitPrices.get("Apple"));

    }
}
