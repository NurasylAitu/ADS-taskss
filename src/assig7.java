import java.util.Scanner;

public class assig7 {
    public static void reverse(int count, Scanner scanner) {
        if (count == 0) return;
        int num = scanner.nextInt();
        reverse(count -1, scanner);
        System.out.print(num + " ");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        reverse(n, scanner);
        scanner.close();
    }
}
