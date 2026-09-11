/*
Author: Roy Lu
Date: September 11th, 2026
Description: User prompted story.
*/

import java.util.Scanner; 

public class Q4 { 
    public static void main(String[] args) { 
        Scanner prompt = new Scanner(System.in); 

        System.out.print("Enter a name: ");
        String name = prompt.nextLine();
        System.out.print("Enter a city: ");
        String city = prompt.nextLine();
        System.out.print("Enter an age: ");
        int age = Integer.parseInt(prompt.nextLine());
        System.out.print("Enter a university: ");
        String university = prompt.nextLine();
        System.out.print("Enter a profession: ");
        String profession = prompt.nextLine();
        System.out.print("Enter an animal: ");
        String animal = prompt.nextLine();
        System.out.print("Enter a pet name: ");
        String petName = prompt.nextLine();
        


        System.out.println("There once was a person named " + name + " who lived in " + city
                + ". At the age of " + age + ", " + name + " went to university at " + university
                + ". " + name + " graduated and went to work as a " + profession + ". Then " + name
                + " adopted a(n) " + animal + " named " + petName + ". They both lived happily ever after!");



    } 
}
