import java.io.*;
import java.util.*;

public class B_18870 {
    private static void sort(Integer[] arr, Integer[] sorted, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int i = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                sorted[i] = arr[l];
                l++;
            } else {
                sorted[i] = arr[r];
                r++;
            }
            i++;
        }

        if (l > mid) {
            while (r <= right) {
                sorted[i] = arr[r];
                r++;
                i++;
            }
        } else {
            while (l <= mid) {
                sorted[i] = arr[l];
                l++;
                i++;
            }
        }

        for (int j = left; j <= right; j++) {
            arr[j] = sorted[j];
        }
    }

    private static void mergeSort(Integer[] arr, Integer[] sorted, int left, int right) {
        for (int size = 1; size <= right; size *= 2) {
            for (int l = left; l <= right - size; l += (size * 2)) {
                int low = l;
                int mid = l + size - 1;
                int high = Math.min(l + (size * 2) - 1, right);
                sort(arr, sorted, low, mid, high);
            }
        }
    }

    private static Map<Integer, Integer> solution(Set<Integer> set) {
        Integer[] arr = set.toArray(new Integer[0]);
        Integer[] sorted = new Integer[set.size()];

        mergeSort(arr, sorted, 0, arr.length - 1);
        sorted = null;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        return map;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        String[] sArr = br.readLine().split(" ");

        int[] arr = new int[count];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < count; i++) {
            int n = Integer.parseInt(sArr[i]);

            arr[i] = n;
            set.add(n);
        }
        br.close();

        Map<Integer, Integer> map = solution(set);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int n : arr) {
            bw.write(String.valueOf(map.get(Integer.valueOf(n))));
            bw.write(" ");
        }
        bw.flush();
        bw.close();
    }
}
