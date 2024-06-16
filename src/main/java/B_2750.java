import java.util.Arrays;
import java.util.Scanner;

public class B_2750 {
    private static void solution(int[] arr) {
        Arrays.sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }

        solution(arr);
    }
}
