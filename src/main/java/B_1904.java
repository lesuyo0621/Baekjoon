import java.io.*;

public class B_1904 {
    private static int solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;

        for (int i = 3; i <= n; i++) {
            nums[i] = (nums[i - 1] + nums[i - 2]) % 15746;
        }

        return nums[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(solution(n)));
        bw.flush();
        bw.close();
    }
}
