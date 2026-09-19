/*
Author: Roy Lu
Date: September 16th, 2026
Description: a program that allows users to select or type an Ojibwe word/phrase to view its
English translation and cultural context, using only Unit 1 Java concepts (variables,
standard I/O, and if-else statements).
*/

import java.util.Scanner;

public class IndigenousCulturalTranslator {
    public static void main(String[] args) {

        // Introduction
        System.out.println("Ojibwe Dictionary\n ---------------");
        System.out.println("[1] Aaniin\n[2] Miigwech\n[3] Akinoomaage\n[4] Mino-bimaadiziwin\n[5] Gichi-apiitendaagozi");

        Scanner input = new Scanner(System.in);


        while (true) {
            System.out.println("Choose a [#] to translate, 0 to exit: ");
            String key = input.next();

            if (key == "1") {
                System.out.print("Original Ojibwe Word: Aaniin");
                System.out.println("English Translation: Hello / I see your light");
                System.out.println("Cultural Meaning & Context: Acknowledges the spiritual presence or light within another person.");
            } else if (key == "2") {
                System.out.print("Original Ojibwe Word: Miigwech");
                System.out.println("English Translation: Thank you");
                System.out.println("Cultural Meaning & Context: Expresses deep gratitude and respect toward community members or nature.");
            } else if (key == "3") {
                System.out.print("Original Ojibwe Word: Akinoomaage");
                System.out.println("English Translation: To teach / To point towards the earth");
                System.out.println("Cultural Meaning & Context: Reflects the worldview that true learning comes from observing the Earth.");
            } else if (key == "4") {
                System.out.print("Original Ojibwe Word: Mino-bimaadiziwin");
                System.out.println("English Translation: The good life");
                System.out.println("Cultural Meaning & Context: A central philosophy of living in balance, health, and harmony with all creation.");
            } else if (key == "5") {
                System.out.print("Original Ojibwe Word: Gichi-apiitendaagozi");
                System.out.println("English Translation: They are of great value");
                System.out.println("Cultural Meaning & Context: Denotes deep respect for Elders and their irreplaceable wisdom.");
            } 
            else if (key == "0") {
                // Exit
                break;
            } else {
                // Error Message
                System.out.println("Invalid key, try entering a number between [1, 5]");
            }
        }



    }
}
