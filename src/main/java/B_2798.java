import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2798 {
    public static int solution(int target, int size, int[] cards) {
        int answer = 0;

        for (int i = 0; i < cards.length - 2; i++) {
            for (int j = i + 1; j < cards.length - 1; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    int sum = cards[i] + cards[j] + cards[k];

                    if (sum <= target && answer < sum) answer = sum;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        br.close();

        int size = Integer.parseInt(s1[0]);
        int target = Integer.parseInt(s1[1]);

        int[] cards = new int[size];
        for (int i = 0; i < size; i++) {
            cards[i] = Integer.parseInt(s2[i]);
        }

        System.out.println(solution(target, size, cards));
    }
}
