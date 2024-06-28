import java.io.*;
import java.util.Arrays;

public class B_1654 {
    private static long[] lan;

    private static long solution(int targetCount) {
        Arrays.sort(lan);
        int lanCount = lan.length;

        long low = 0;
        long high = lan[lanCount - 1] + 1;
        long mid = 0;

        while (low < high) {
            mid = (low + high) / 2;

            long count = 0;
            for (int i = 0; i < lanCount; i++) {
                count += (lan[i] / mid);
            }

            if (count < targetCount) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().split(" ");
        int count = Integer.parseInt(condition[0]);
        int targetCount = Integer.parseInt(condition[1]);

        lan = new long[count];
        for (int i = 0; i < count; i++) {
            lan[i] = Long.parseLong(br.readLine());
        }
        br.close();

        long length = solution(targetCount);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(length));
        bw.flush();
        bw.close();
    }
}
