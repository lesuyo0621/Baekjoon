import java.io.*;

public class B_24416 {
    private static int recursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return recursion(n - 1) + recursion(n - 2);
        }
    }

    private static int dynamic(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 1;

        int count = 0;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
            count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(recursion(n) + " " + dynamic(n));
        bw.flush();
        bw.close();
    }
}
