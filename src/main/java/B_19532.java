import java.util.Scanner;

public class B_19532 {
    private static int[] solution(int a, int b, int c, int d, int e, int f){
        for (int i = 0; i <= 1998; i++) {
            int x = -999 + i;

            for (int j = 0; j <= 1998; j++) {
                int y = -999 + j;

                if ((a * x) + (b * y) == c && (d * x) + (e * y) == f) {
                    return new int[]{x, y};
                }
            }
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sArr = sc.nextLine().split(" ");
        int[] nums = new int[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            nums[i] = Integer.parseInt(sArr[i]);
        }

        int[] answer = solution(nums[0], nums[1], nums[2], nums[3], nums[4], nums[5]);
        String answerStr = answer[0] + " " + answer[1];
        System.out.println(answerStr);
    }
}
