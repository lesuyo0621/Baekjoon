import java.io.*;

public class B_2630 {
    private static int whiteCount = 0;
    private static int blueCount = 0;

    private static void find(int s, int n, int length, String[] papers) {
        boolean white = papers[s / length].charAt(s % length) == '0';
        boolean divide = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int pos = s + j + (i * length);
                char p = papers[pos / length].charAt(pos % length);

                if (white) {
                    if (p != '0') {
                        divide = true;
                        break;
                    }
                } else {
                    if (p != '1') {
                        divide = true;
                        break;
                    }
                }
            }

            if (divide) break;
        }

        if (divide) {
            find(s, n / 2, length, papers);
            find(s + (n / 2), n / 2, length, papers);
            find(s + ((n / 2) * length), n / 2, length, papers);
            find(s + ((n / 2) * length) + (n / 2), n / 2, length, papers);
        } else {
            if (white) {
                whiteCount++;
            } else {
                blueCount++;
            }
        }
    }

    private static void solution(int n, String[] papers) {
        find(0, n, n, papers);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] papers = new String[n];
        for (int i = 0; i < n; i++) {
            papers[i] = br.readLine().replaceAll(" ", "");
        }

        solution(n, papers);
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(whiteCount));
        bw.write("\n");
        bw.write(String.valueOf(blueCount));
        bw.flush();
        bw.close();
    }
}
