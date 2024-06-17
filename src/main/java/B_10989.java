import java.io.*;

public class B_10989 {
    private static void sort(int[] nums, int[] sorted, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int i = left;

        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                sorted[i] = nums[l];
                l++;
            } else {
                sorted[i] = nums[r];
                r++;
            }

            i++;
        }

        if (l > mid) {
            while (r <= right) {
                sorted[i] = nums[r];
                r++;
                i++;
            }
        } else {
            while (l <= mid) {
                sorted[i] = nums[l];
                l++;
                i++;
            }
        }

        for (int j = left; j <= right; j++) {
            nums[j] = sorted[j];
        }
    }

    private static void mergeSort(int[] nums, int[] sorted, int left, int right) {
        for (int size = 1; size <= right; size *= 2) {
            for (int l = left; l <= right - size; l += (size * 2)) {
                int low = l;
                int mid = l + size - 1;
                int high = Math.min(l + (size * 2) - 1, right);
                sort(nums, sorted, low, mid, high);
            }
        }
    }

    private static void solution(int[] nums) {
        int[] sorted = new int[nums.length];
        mergeSort(nums, sorted, 0, nums.length - 1);
        sorted = null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        solution(nums);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int n : nums) {
            bw.write(n + "\n");
        }
        bw.flush();
        bw.close();
    }
}
