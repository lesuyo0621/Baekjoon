import java.io.*;

public class B_11051 {
    private static int[][] cache;

    private static int solution(int n, int k) {
        if (cache[n][k] > 0) {
            return cache[n][k];
        }

        if (k == 0 || k == n) {
            return cache[n][k] = 1;
        }

        return cache[n][k] = (solution(n - 1, k) + solution(n - 1, k - 1)) % 10007;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        br.close();

        int n = Integer.parseInt(nums[0]);
        int k = Integer.parseInt(nums[1]);
        cache = new int[n + 1][k + 1];
        int answer = solution(n, k);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
