import java.io.*;

public class B_1932 {
    private static int solution(String[] nums) {
        int[] sum = new int[nums.length];

        String[] init = nums[nums.length - 1].split(" ");
        for (int i = 0; i < sum.length; i++) {
            sum[i] = Integer.parseInt(init[i]);
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            String[] prev = nums[i].split(" ");

            for (int j = 0; j < prev.length; j++) {
                int prevNum = Integer.parseInt(prev[j]);

                sum[j] = prevNum + Math.max(sum[j], sum[j + 1]);
            }
        }

        return sum[0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        String[] nums = new String[count];
        for (int i = 0; i < count; i++) {
            nums[i] = br.readLine();
        }
        br.close();

        int max = solution(nums);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
