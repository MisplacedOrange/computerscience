public class Q4 {
    public static void main(String[] args) {
        int num1 = (int)(Math.random()*6) + 1;
        int num2 = (int)(Math.random()*6) + 1;

        System.out.println("The first die comes up " + num1);
        System.out.println("The second die comes up " + num2);
        System.out.println("Your total roll is " + (num1 + num2));
        
    }
}
