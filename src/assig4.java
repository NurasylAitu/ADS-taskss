import java.util.Scanner;
public class assig4 {
    public static long factorial(int n) {
        if (n==0 || n ==1) return 1;
        return n*factorial(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n<0){
            System.out.println("-1");
        } else {
            System.out.println(factorial(n));
        }
        sc.close();
    }
}
