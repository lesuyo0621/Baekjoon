import java.io.*;

public class B_11401 {
    private static final long MOD = 1000000007;

    private static long pow(long num, long n) {
        if (n == 1) {
            return num % MOD;
        }

        long result;
        long temp = pow(num, n / 2);

        if (n % 2 == 1) {
            result = (temp * temp % MOD) * num % MOD;
        } else {
            result = temp * temp % MOD;
        }

        return result % MOD;
    }

    private static long factorial(int n) {
        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
            result %= MOD;
        }

        return result;
    }

    private static long solution(int n, int k) {
        long numerator = factorial(n);
        long denominator = factorial(k) * factorial(n - k) % MOD;

        return numerator * pow(denominator, MOD - 2) % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        br.close();

        int n = Integer.parseInt(nums[0]);
        int k = Integer.parseInt(nums[1]);
        long answer = solution(n, k);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
