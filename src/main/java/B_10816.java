import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class B_10816 {
    private static Map<Integer, Integer> map = new HashMap<>();
    private static StringBuilder sb = new StringBuilder();

    private static void solution(String[] targetArr) {
        for (String t : targetArr) {
            int tNum = Integer.parseInt(t);
            if (sb.length() > 0) sb.append(" ");

            if (map.containsKey(tNum)) {
                sb.append(map.get(tNum));
            } else {
                sb.append(0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        String[] numsStr = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(numsStr[i]);

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        br.readLine();
        String[] targetArr = br.readLine().split(" ");
        br.close();

        solution(targetArr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
