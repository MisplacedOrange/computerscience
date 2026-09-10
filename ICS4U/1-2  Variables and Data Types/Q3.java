public class Q3 {
     public static void main(String[] args) {
        // temp
        short num = 32767;
        System.out.println("A short: " + num);
        // the value of num that will produce an error is when num < -32769 and num > 32767 as these are the definite integer limits for 16 bit operations.
    }
}
