import java.io.*;

public class B_1149 {
    private static int solution(int[][] cost) {
        for (int i = 1; i < cost.length; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] += Math.min(cost[i - 1][(j + 1) % 3], cost[i - 1][(j + 2) % 3]);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (cost[cost.length - 1][i] < min) min = cost[cost.length - 1][i];
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[][] cost = new int[count][3];
        for (int i = 0; i < count; i++) {
            String[] rgb = br.readLine().split(" ");
            cost[i] = new int[]{Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2])};
        }
        br.close();

        int min = solution(cost);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}
