import java.io.*;

public class B_1427 {
    private static void sort(char[] cArr, char[] sorted, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int i = left;

        while (l <= mid && r <= right) {
            if (cArr[l] >= cArr[r]) {
                sorted[i] = cArr[l];
                l++;
            } else {
                sorted[i] = cArr[r];
                r++;
            }

            i++;
        }

        if (l > mid) {
            while (r <= right) {
                sorted[i] = cArr[r];
                r++;
                i++;
            }
        }else {
            while (l <= mid) {
                sorted[i] = cArr[l];
                l++;
                i++;
            }
        }

        for (int j = left; j <= right; j++) {
            cArr[j] = sorted[j];
        }
    }

    private static void mergeSort(char[] cArr, char[] sorted, int left, int right) {
        for (int size = 1; size <= right; size *= 2) {
            for (int l = left; l <= right - size; l += (size * 2)) {
                int low = l;
                int mid = l + size - 1;
                int high = Math.min(l + (size * 2) - 1, right);
                sort(cArr, sorted, low, mid, high);
            }
        }
    }

    private static String solution(char[] cArr) {
        char[] sorted = new char[cArr.length];
        mergeSort(cArr, sorted, 0, cArr.length - 1);
        sorted = null;

        return new String(cArr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(solution(s.toCharArray()));
        bw.flush();
        bw.close();
    }
}
