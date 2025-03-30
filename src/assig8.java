import java.util.Scanner;
public class assig8 {
    public static boolean check(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        String input = sc.next();
        sc.close();
        System.out.println(check(input) ? "YES" : "NO");
    }
}
