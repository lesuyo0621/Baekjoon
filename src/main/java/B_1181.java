import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class B_1181 {
    private static void sort(String[] sArr, String[] sorted, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int i = left;

        while (l <= mid && r <= right) {
            boolean leftSmall = false;

            if (sArr[l].length() < sArr[r].length()) {
                leftSmall = true;
            } else if (sArr[l].length() == sArr[r].length()) {
                if (sArr[l].compareTo(sArr[r]) < 0) {
                    leftSmall = true;
                }
            }

            if (leftSmall) {
                sorted[i] = sArr[l];
                l++;
            } else {
                sorted[i] = sArr[r];
                r++;
            }
            i++;
        }

        if (l > mid) {
            while (r <= right) {
                sorted[i] = sArr[r];
                r++;
                i++;
            }
        } else {
            while (l <= mid) {
                sorted[i] = sArr[l];
                l++;
                i++;
            }
        }

        for (int j = left; j <= right; j++) {
            sArr[j] = sorted[j];
        }
    }

    private static void mergeSort(String[] sArr, String[] sorted, int left, int right) {
        for (int size = 1; size <= right; size *= 2) {
            for (int l = left; l <= right - size; l += (size * 2)) {
                int low = l;
                int mid = l + size - 1;
                int high = Math.min(l + (size * 2) - 1, right);
                sort(sArr, sorted, low, mid, high);
            }
        }
    }

    private static void solution(String[] sArr) {
        String[] sorted = new String[sArr.length];
        mergeSort(sArr, sorted, 0, sArr.length - 1);
        sorted = null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < count; i++) {
            set.add(br.readLine());
        }
        br.close();

        String[] sArr = set.toArray(new String[0]);
        solution(sArr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : sArr) {
            bw.write(s);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
