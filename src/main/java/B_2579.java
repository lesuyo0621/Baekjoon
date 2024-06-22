import java.io.*;

public class B_2579 {
    private static int solution(int[] nums) {
        if (nums.length <= 2) return nums[nums.length - 1];

        int[] sum = new int[nums.length];
        sum[1] = nums[1];
        sum[2] = nums[1] + nums[2];

        for (int i = 3; i < nums.length; i++) {
            sum[i] = Math.max(sum[i - 3] + nums[i - 1], sum[i - 2]) + nums[i];
        }

        return sum[sum.length - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] nums = new int[count + 1];
        for (int i = 1; i <= count; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int max = solution(nums);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
