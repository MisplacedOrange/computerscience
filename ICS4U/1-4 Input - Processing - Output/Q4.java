/*
Author: Roy Lu
Date: September 11th, 2026
Description: User prompted story.
*/

import java.util.Scanner; 

public class Q4 { 
    public static void main(String[] args) { 
        Scanner prompt = new Scanner(System.in); 

        String Name = prompt.nextLine();
        String City = prompt.nextLine();
        int Age = Integer.parseInt(prompt.nextLine());
        String University = prompt.nextLine();
        String Profession = prompt.nextLine();
        String Animal = prompt.nextLine();
        String PetName = prompt.nextLine();
        


        System.out.println("There once was a person named " + Name + " who lived in " + City + ". At the age of "  + Age + ", " + Name + " went to university at " + University + ". " + Name + " graduated and went to work as a " + Profession + ". Then " + Name + " adopted a(n) " + Animal + " named " + PetName + ". They both lived happily ever after!");



    } 
}
