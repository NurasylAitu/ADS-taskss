import java.util.Scanner;
public class Assignment1 {
    static int findMin(int[] arr, int index) {
        if (index == arr.length - 1)
            return arr[index];
        return Math.min(arr[index], findMin(arr, index + 1));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(findMin(arr, 0));
        scanner.close();
    }
}

