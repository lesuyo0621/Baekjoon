import java.io.*;

public class B_13275 {
    private static String preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");

        for (char c : s.toCharArray()) {
            sb.append(c);
            sb.append("#");
        }

        return sb.toString();
    }

    private static int solution(String s) {
        char[] cArr = preprocess(s).toCharArray();
        int len = cArr.length;
        int[] P = new int[len];
        int center = 0, right = 0;

        for (int i = 0; i < len; i++) {
            int mirror = center * 2 - i;

            if (i < right) {
                P[i] = Math.min(P[mirror], right - i);
            }

            int l = i - (P[i] + 1);
            int r = i + (P[i] + 1);
            while (l >= 0 && r < len && cArr[l] == cArr[r]) {
                P[i]++;
                l--;
                r++;
            }

            if (i + P[i] > right) {
                center = i;
                right = i + P[i];
            }
        }

        int max = 0;
        for (int p : P) {
            if (p > max) max = p;
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(solution(s)));
        bw.flush();
        bw.close();
    }
}
