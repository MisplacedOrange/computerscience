public class Q7 {
    public static double degreetoradian (double deg) {
        double rad = deg * Math.PI/180;
        return rad;
    }
    public static double radiantodegree (double rad) {
        double deg = rad * 180/Math.PI;
        return deg;
    }
    
    public static void main(String[] args) {
        System.out.println(degreetoradian(90));
        System.out.println(radiantodegree(90));
    }
}
