import java.io.*;

public class B_1992 {
    private static void compression(int s, int n, int length, String[] pixels, StringBuilder sb) {
        char t = pixels[s / length].charAt(s % length);
        boolean divide = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int pos = s + j + (i * length);
                char p = pixels[pos / length].charAt(pos % length);

                if (t != p) {
                    divide = true;
                    break;
                }
            }

            if (divide) break;
        }

        if (divide) {
            sb.append("(");
            compression(s, n / 2, length, pixels, sb);
            compression(s + n / 2, n / 2, length, pixels, sb);
            compression(s + ((n / 2) * length), n / 2, length, pixels, sb);
            compression(s + n / 2 + ((n / 2) * length), n / 2, length, pixels, sb);
            sb.append(")");
        } else {
            sb.append(t);
        }
    }

    private static String solution(int n, String[] pixels) {
        StringBuilder sb = new StringBuilder();

        compression(0, n, n, pixels, sb);

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] pixels = new String[n];
        for (int i = 0; i < n; i++) {
            pixels[i] = br.readLine();
        }
        br.close();

        String answer = solution(n, pixels);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
