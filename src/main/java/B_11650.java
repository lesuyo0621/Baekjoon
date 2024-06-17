import java.io.*;

public class B_11650 {
    private static void sort(int[][] arr, int[][] sorted, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int i = left;

        while (l <= mid && r <= right) {
            boolean leftSmall = false;

            if (arr[l][0] < arr[r][0]) {
                leftSmall = true;
            } else if (arr[l][0] == arr[r][0]) {
                if (arr[l][1] <= arr[r][1]) {
                    leftSmall = true;
                } else {
                    leftSmall = false;
                }
            } else {
                leftSmall = false;
            }

            if (leftSmall) {
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

    private static void mergeSort(int[][] arr, int[][] sorted, int left, int right) {
        for (int size = 1; size <= right; size *= 2) {
            for (int l = left; l <= right - size; l += (size * 2)) {
                int low = l;
                int mid = l + size - 1;
                int high = Math.min(l + (size * 2) - 1, right);
                sort(arr, sorted, low, mid, high);
            }
        }
    }

    private static void solution(int[][] arr) {
        int[][] sorted = new int[arr.length][2];
        mergeSort(arr, sorted, 0, arr.length - 1);
        sorted = null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[][] arr = new int[count][2];
        for (int i = 0 ; i < count; i++) {
            String[] sArr = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(sArr[0]);
            arr[i][1] = Integer.parseInt(sArr[1]);
        }
        br.close();

        solution(arr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < arr.length; i++) {
            bw.write(String.valueOf(arr[i][0]));
            bw.write(" ");
            bw.write(String.valueOf(arr[i][1]));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
