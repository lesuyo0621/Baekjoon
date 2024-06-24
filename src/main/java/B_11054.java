import java.io.*;

public class B_11054 {
    private static int solution(int[] nums) {
        int[] incDp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            incDp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    incDp[i] = Math.max(incDp[i], incDp[j] + 1);
                }
            }
        }

        int[] decDp = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            decDp[i] = 1;

            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    decDp[i] = Math.max(decDp[i], decDp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < incDp.length; i++) {
            int sum = incDp[i] + decDp[i] - 1;

            if (maxLength < sum) maxLength = sum;
        }

        return maxLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] numStr = br.readLine().split(" ");
        br.close();

        int[] nums = new int[numStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
        }

        int max = solution(nums);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
