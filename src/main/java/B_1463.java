import java.io.*;

public class B_1463 {
    private static int solution(int num) {
        if (num == 1) return 0;

        int[] dp = new int[num + 1];
        dp[0] = dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= num; i++) {
            int divide3 = i % 3 == 0 ? dp[i / 3] : Integer.MAX_VALUE;
            int divide2 = i % 2 == 0 ? dp[i / 2] : Integer.MAX_VALUE;
            int minus1 = dp[i - 1];

            dp[i] = Math.min(Math.min(divide2, divide3), minus1) + 1;
        }

        return dp[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        br.close();

        int count = solution(num);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
