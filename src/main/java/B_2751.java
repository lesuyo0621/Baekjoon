import java.io.*;

public class B_2751 {
    private static void merge(int[] origin, int[] sorted, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int i = left;

        while (l <= mid && r <= right) {
            if (origin[l] <= origin[r]) {
                sorted[i] = origin[l];
                l++;
            } else {
                sorted[i] = origin[r];
                r++;
            }

            i++;
        }

        if (l > mid) {
            while (r <= right) {
                sorted[i] = origin[r];
                r++;
                i++;
            }
        } else {
            while (l <= mid) {
                sorted[i] = origin[l];
                l++;
                i++;
            }
        }

        for (int j = left; j <= right; j++) {
            origin[j] = sorted[j];
        }
    }

    private static void sort(int[] origin, int[] sorted, int left, int right) {
        for (int size = 1; size <= right; size *= 2) {
            for (int l = 0; l <= right - size; l += (size * 2)) {
                int low = l;
                int mid = l + size - 1;
                int high = Math.min(l + (size * 2) - 1, right);
                merge(origin, sorted, low, mid, high);
            }
        }
    }

    private static void solution(int[] nums) {
        int[] sorted = new int[nums.length];
        sort(nums, sorted, 0, nums.length - 1);
        sorted = null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());

        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = Integer.parseInt(bf.readLine());
        }
        bf.close();

        solution(nums);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int n : nums) {
            bw.write(n + "\n");
        }
        bw.flush();
        bw.close();
    }
}
