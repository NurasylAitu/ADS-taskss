import java.util.Scanner;
public class assig6 {
    public static long power(int a, int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= a;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите a и n: ");
        int a = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(power(a, n));
        scanner.close();
    }
}
