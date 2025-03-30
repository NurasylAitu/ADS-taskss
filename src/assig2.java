import java.util.Scanner;
public class assig2 {
    public static double average(int n, int[] arr){
        if (n==0) return 0;
        int sum=0;
        for(int num:arr){
            sum+=num;
        }
        return (double) sum/n;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n<=0){
            System.out.println(0);
            return;
        }
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        double average = average(n, numbers);
        System.out.println(average);
        scanner.close();
    }
}
