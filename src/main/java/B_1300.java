import java.io.*;

public class B_1300 {
    private static long solution(int n, int k) {
        int low = 1;
        int high = k;
        while (low < high) {
            int mid = (low + high) / 2;

            long count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min((mid / i), n);
            }

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        br.close();

        long answer = solution(n, k);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
