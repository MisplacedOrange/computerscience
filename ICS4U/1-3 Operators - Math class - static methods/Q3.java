public class Q3 {
    public static void main(String[] args) {
        int n = 1;
        int money = 21000;
        double interest = 0.054;
        System.out.println("The interest is " + interest*100 + "% and the value of the investment after " + n + " year(s) is $" + (money * (1 + interest * n)));
    }
}
