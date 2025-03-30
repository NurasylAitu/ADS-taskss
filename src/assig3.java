import java.util.Scanner;
public class assig3 {
    public static boolean recursive(int n, int divisor) {
        if (n <= 1) return false;
        if (divisor * divisor > n) return true;
        if (n % divisor == 0) return false;
        return recursive(n, divisor + 1);
    }
    public static boolean isPrime(int n) {
        return recursive(n, 2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        int n = scanner.nextInt();
        if (isPrime(n)) {
            System.out.println("Prime");
        } else {
            System.out.println("Composite");
        }
        scanner.close();
    }
}
