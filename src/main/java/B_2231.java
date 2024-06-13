import java.util.Scanner;

public class B_2231 {
    private static int solution(int num) {
        int start = num - (9 * String.valueOf(num).length());

        for (int i = start; i < num; i++) {
            String targetStr = String.valueOf(i);

            int sum = 0;
            for (int j = 0; j < targetStr.length(); j++) {
                sum += Character.getNumericValue(targetStr.charAt(j));
            }

            if (i + sum == num) return i;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        System.out.println(solution(num));
    }
}
