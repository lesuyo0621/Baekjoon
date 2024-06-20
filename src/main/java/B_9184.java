import java.io.*;

public class B_9184 {
    private static int solution(int a, int b, int c, boolean[][][] check, int[][][] result) {
        int A = a + 50;
        int B = b + 50;
        int C = c + 50;

        if (check[A][B][C]) return result[A][B][C];
        check[A][B][C] = true;

        if (a <= 0 || b <= 0 || c <= 0) {
            result[A][B][C] = 1;
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            result[A][B][C] = solution(20, 20, 20, check, result);
            return result[A][B][C];
        }

        if (a < b && b < c) {
            result[A][B][C]
                    = solution(a, b, c - 1, check, result)
                    + solution(a, b -1, c -1, check, result)
                    - solution(a, b - 1, c, check, result);

            return result[A][B][C];
        }

        result[A][B][C]
                = solution(a - 1, b, c, check, result)
                + solution(a - 1, b - 1, c, check, result)
                + solution(a - 1, b, c - 1, check, result)
                - solution(a - 1, b - 1, c - 1, check, result);

        return result[A][B][C];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[][][] check = new boolean[101][101][101];
        int[][][] result = new int[101][101][101];

        String s = br.readLine();
        while (!"-1 -1 -1".equals(s)) {
            String[] sArr = s.split(" ");
            int a = Integer.parseInt(sArr[0]);
            int b = Integer.parseInt(sArr[1]);
            int c = Integer.parseInt(sArr[2]);

            bw.write("w(" + a + ", " + b + ", " + c +") = " + solution(a, b, c, check, result));
            bw.write("\n");
            s = br.readLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
