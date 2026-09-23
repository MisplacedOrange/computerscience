/*
Author: Roy Lu
Date: September 16th, 2026
Description: A program that allows users to select or type an Ojibwe word/phrase to view its
English translation and cultural context, using only Unit 1 Java concepts
(variables, standard I/O, and if-else statements).
*/

import java.util.Scanner;

public class IndigenousCulturalTranslator {
    /*
    Purpose: Provides English translations and cultural context for various
    Ojibwe words and phrases.
    */

    public static void main(String[] args) {
        /*
        Purpose: Displays an Ojibwe dictionary and allows the user to select
        words or phrases to translate.
        Parameters: Command line arguments are passed in, but are not used.
        Return Value: n/a
        */

        Scanner input = new Scanner(System.in);

        // Menu
        System.out.println("Ojibwe Dictionary");
        System.out.println("---------------");
        System.out.println("[1] Aaniin");
        System.out.println("[2] Miigwech");
        System.out.println("[3] Akinoomaage");
        System.out.println("[4] Mino-bimaadiziwin");
        System.out.println("[5] Gichi-apiitendaagozi");

        while (true) {
            System.out.println();
            System.out.println("Choose a [#] to translate, 0 to exit: ");
            String selection = input.nextLine();

            if (selection.equals("0")) {
                // Exit
                break;
            }

            translate(selection);
        }

        input.close();
    }

    public static void translate(String selection) {
        /*
        Purpose: Translates the selected Ojibwe word and displays its English
        translation and cultural context.
        Parameters: selection is the user's selected translation option.
        */

        if (selection.equals("1")) {
            System.out.println("Original Ojibwe Word: Aaniin");
            System.out.println("English Translation: Hello / I see your light");
            System.out.println("Cultural Meaning & Context: Acknowledges the spiritual presence or light within another person.");
        } else if (selection.equals("2")) {
            System.out.println("Original Ojibwe Word: Miigwech");
            System.out.println("English Translation: Thank you");
            System.out.println("Cultural Meaning & Context: Expresses deep gratitude and respect toward community members or nature.");
        } else if (selection.equals("3")) {
            System.out.println("Original Ojibwe Word: Akinoomaage");
            System.out.println("English Translation: To teach / To point towards the earth");
            System.out.println("Cultural Meaning & Context: Reflects the worldview that true learning comes from observing the Earth.");
        } else if (selection.equals("4")) {
            System.out.println("Original Ojibwe Word: Mino-bimaadiziwin");
            System.out.println("English Translation: The good life");
            System.out.println("Cultural Meaning & Context: A central philosophy of living in balance, health, and harmony with all creation.");
        } else if (selection.equals("5")) {
            System.out.println("Original Ojibwe Word: Gichi-apiitendaagozi");
            System.out.println("English Translation: They are of great value");
            System.out.println("Cultural Meaning & Context: Denotes deep respect for Elders and their irreplaceable wisdom.");
        } else {
            // Error message / handling
            System.out.println("Invalid key, try entering a number between [1, 5]");
        }
    }
}
