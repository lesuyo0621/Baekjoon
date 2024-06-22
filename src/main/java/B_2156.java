import java.io.*;

public class B_2156 {
    private static int solution(int[] wines) {
        if (wines.length < 3) {
            int sum = 0;

            for (int w : wines) {
                sum += w;
            }

            return sum;
        }

        int[] dp = new int[wines.length];
        dp[0] = wines[0];
        dp[1] = wines[1];
        dp[2] = wines[1] + wines[2];

        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(Math.max(dp[i - 3] + wines[i - 1], dp[i - 2]) + wines[i], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] wines = new int[count + 1];
        for (int i = 1; i <= count; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int max = solution(wines);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
