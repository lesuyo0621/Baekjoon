import java.util.Scanner;

public class B_2839 {
    private static int solution(int kg) {
        int quotient = kg / 5;

        while (quotient >= 0) {
            int remainder = kg - (quotient * 5);

            if (remainder % 3 == 0) {
                return quotient + (remainder / 3);
            } else {
                quotient--;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kg = sc.nextInt();

        System.out.println(solution(kg));
    }
}
