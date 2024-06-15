import java.util.Scanner;

public class B_1436 {
    private static int solution(int num) {
        int targetNum = 666;

        for (int i = 2; i <= num; i++) {
            int sixCount = 0;

            while (sixCount < 3) {
                sixCount = 0;
                int n = ++targetNum;

                while (n > 0) {
                    if (n % 10 == 6) {
                        sixCount++;
                    } else {
                        sixCount = 0;
                    }

                    if (sixCount >= 3) break;

                    n /= 10;
                }
            }
        }

        return targetNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        System.out.println(solution(num));
    }
}
