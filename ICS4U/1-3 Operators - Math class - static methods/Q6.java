public class Q6 {
    public static void main(String[] args){
        int a = 3;
        int b = -8;
        int c = 4;

        double x1 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c)) / 2*a;
        double x2 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c)) / 2*a;

        System.out.println("r1 = " + x1 + ", r2 = " + x2);
    }

}
