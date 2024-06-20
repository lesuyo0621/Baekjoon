import java.io.*;

public class B_9461 {
    private static long solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 1;

        long[] nums = new long[n + 1];
        nums[1] = 1;
        nums[2] = 1;
        nums[3] = 1;

        for (int i = 4; i <= n; i++) {
            nums[i] = nums[i - 2] + nums[i - 3];
        }

        return nums[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        long[] answer = new long[count];
        for (int i = 0; i < count; i++) {
            answer[i] = solution(Integer.parseInt(br.readLine()));
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (long a : answer) {
            bw.write(String.valueOf(a));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
