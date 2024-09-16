import java.io.*;

public class B_1780 {
    private static int minusOueCount = 0;
    private static int zeroCount = 0;
    private static int oneCont = 0;

    private static void find(int s, int n, int length, String[][] papers) {
        String t = papers[s / length][s % length];
        boolean divide = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int pos = s + j + (i * length);
                String p = papers[pos / length][pos % length];

                if (!t.equals(p)) {
                    divide = true;
                    break;
                }
            }

            if (divide) break;
        }

        if (divide) {
            for (int i = 0; i < 3; i++) {
                int row = i * length * (n / 3);

                for (int j = 0; j < 3; j++) {
                    int col = j * (n / 3);
                    int pos = s + row + col;

                    find(pos, n / 3, length, papers);
                }
            }
        } else {
            switch (t) {
                case "-1":
                    minusOueCount++;
                    break;
                case "0":
                    zeroCount++;
                    break;
                case "1":
                    oneCont++;
                    break;
            }
        }
    }

    private static void solution(int n, String[][] papers) {
        find(0, n, n, papers);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] papers = new String[n][n];
        for (int i = 0; i < n; i++) {
            papers[i] = br.readLine().split(" ");
        }
        br.close();

        solution(n, papers);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(minusOueCount));
        bw.write("\n");
        bw.write(String.valueOf(zeroCount));
        bw.write("\n");
        bw.write(String.valueOf(oneCont));
        bw.flush();
        bw.close();
    }
}
