import java.io.*;

public class B_1629 {
    private static long pow(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long temp = pow(a, b / 2, c);

        if (b % 2 == 1) {
            return (temp * temp % c) * a % c;
        } else {
            return temp * temp % c;
        }
    }

    private static int solution(int a, int b, int c) {
        return (int) pow(a, b, c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] abc = br.readLine().split(" ");
        br.close();

        int a = Integer.parseInt(abc[0]);
        int b = Integer.parseInt(abc[1]);
        int c = Integer.parseInt(abc[2]);
        int answer = solution(a, b, c);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
