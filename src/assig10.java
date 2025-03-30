import java.util.Scanner;
public class assig10 {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        System.out.println(gcd(a, b));
    }

}
