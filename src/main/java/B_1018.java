import java.util.Scanner;

public class B_1018 {
    private static int counting(String[] chess, char[] tile, int nAcc, int mAcc) {
        int count = 0;

        for (int i = nAcc; i < nAcc + 8; i++) {
            String c = chess[i];

            for (int j = mAcc; j < mAcc + 8; j++) {
                if (c.charAt(j) != tile[(i + j) % 2]) count++;
            }
        }

        return count;
    }

    private static int solution(int n, int m, String[] chess) {
        int answer = Integer.MAX_VALUE;

        int nAcc = 0;
        int mAcc = 0;
        char[] tile = new char[2];
        while (nAcc <= n - 8) {
            tile[0] = 'B';
            tile[1] = 'W';
            int count1 = counting(chess, tile, nAcc, mAcc);

            tile[0] = 'W';
            tile[1] = 'B';
            int count2 = counting(chess, tile, nAcc, mAcc);

            int min = Integer.min(count1, count2);
            answer = Integer.min(answer, min);
            if (answer == 0) break;

            if (mAcc < m - 8) {
                mAcc++;
            } else if (mAcc >= m - 8 && nAcc <= n - 8) {
                nAcc++;
                mAcc = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        String[] chess = new String[n];
        for (int i = 0; i < n; i++) {
            chess[i] = sc.nextLine();
        }
        sc.close();

        System.out.println(solution(n, m, chess));
    }
}
