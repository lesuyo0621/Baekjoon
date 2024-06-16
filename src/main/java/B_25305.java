import java.util.Arrays;
import java.util.Scanner;

public class B_25305 {
    private static int solution(int[] scores, int prizeCount) {
        Arrays.sort(scores);
        return scores[scores.length - prizeCount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int peopleCount = sc.nextInt();
        int prizeCount = sc.nextInt();
        sc.nextLine();

        String score = sc.nextLine();
        sc.close();

        String[] sArr = score.split(" ");
        int[] scores = new int[peopleCount];
        for (int i = 0; i < peopleCount; i++) {
            scores[i] = Integer.parseInt(sArr[i]);
        }

        System.out.println(solution(scores, prizeCount));
    }
}
