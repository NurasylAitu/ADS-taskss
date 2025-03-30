import java.util.Scanner;
public class assig9 {
    public static int binomial (int n, int k){
        if (k > n) {
            return 0;
        }
        if (k == 0 || k == n){
            return 1;
        }
        return binomial(n-1, k-1) + binomial(n-1, k);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        System.out.println(binomial(n,k));
    }
}
