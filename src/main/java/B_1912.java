import java.io.*;

public class B_1912 {
    private static int solution(int[] nums) {
        int max = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);

            if (max < sum) max = sum;
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] nums = new int[count];
        String[] numStr = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
        }
        br.close();

        int max = solution(nums);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
