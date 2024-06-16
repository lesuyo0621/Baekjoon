import java.util.Arrays;
import java.util.Scanner;

public class B_2587 {
    private static void solution(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        System.out.println(sum / 5);
        System.out.println(nums[2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        solution(nums);
    }
}
