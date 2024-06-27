import java.io.*;
import java.util.Arrays;

public class B_1920 {
    private static StringBuilder sb = new StringBuilder();

    private static void solution(int[] nums, int[] target) {
        Arrays.sort(nums);

        for (int t : target) {
            int low = 0;
            int high = nums.length - 1;
            int mid = (low + high) / 2;

            while (low < high) {
                if (t > nums[mid]) {
                    low = mid + 1;
                } else if (t < nums[mid]) {
                    high = mid - 1;
                } else {
                    break;
                }

                mid = (low + high) / 2;
            }

            if (t == nums[low] || t == nums[mid]) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] nums = new int[count];
        String[] numsStr = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        int targetCount = Integer.parseInt(br.readLine());

        int[] target = new int[targetCount];
        String[] targetStr = br.readLine().split(" ");
        for (int i = 0; i < targetCount; i++) {
            target[i] = Integer.parseInt(targetStr[i]);
        }
        br.close();

        solution(nums, target);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
