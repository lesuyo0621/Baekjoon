import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class B_10815 {
    private static String solution(String[] card, String[] target) {
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();
        for (String c : card) {
            set.add(Integer.parseInt(c));
        }

        for (String c : target) {
            if (sb.length() > 0) sb.append(" ");

            if (set.contains(Integer.parseInt(c))) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] card = br.readLine().split(" ");

        br.readLine();
        String[] card2 = br.readLine().split(" ");
        br.close();

        String answer = solution(card, card2);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
