import java.io.*;

public class B_11053 {
    private static int solution(int[] nums) {
        int maxLength = 1;

        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (maxLength < dp[i]) maxLength = dp[i];
        }

        return maxLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String[] numStr = br.readLine().split(" ");
        int[] nums = new int[numStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
        }
        br.close();

        int length = solution(nums);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(length));
        bw.flush();
        bw.close();
    }
}
