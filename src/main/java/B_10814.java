import java.io.*;

public class B_10814 {
    private static void sort(String[] sArr, String[] sorted, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int i = left;

        while (l <= mid && r <= right) {
            String[] lArr = sArr[l].split(" ");
            String[] rArr = sArr[r].split(" ");

            if (Integer.parseInt(lArr[0]) <= Integer.parseInt(rArr[0])) {
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

        String[] sArr = new String[count];
        for (int i = 0; i < count; i++) {
            sArr[i] = br.readLine();
        }
        br.close();

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
