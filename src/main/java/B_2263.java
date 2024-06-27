import java.io.*;

public class B_2263 {
    private static String[] inOrder;
    private static String[] postOrder;
    private static StringBuilder sb = new StringBuilder();

    private static void findNode(int ios, int ioe, int pos, int poe) {
        if (ios > ioe || pos > poe) return;

        String root = postOrder[poe];

        if (sb.length() > 0) sb.append(" ");
        sb.append(root);

        int rootIndex = ios;
        for (int i = ios; i <= ioe; i++) {
            if (root.equals(inOrder[i])) {
                rootIndex = i;
                break;
            }
        }

        int rightCount = ioe - rootIndex;

        findNode(ios, rootIndex - 1, pos,poe - rightCount - 1);
        findNode(rootIndex + 1, ioe, poe - rightCount, poe - 1);
    }

    private static void solution() {
        int ios = 0;
        int ioe = inOrder.length - 1;

        int pos = 0;
        int poe = postOrder.length - 1;

        findNode(ios, ioe, pos, poe);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        inOrder = br.readLine().split(" ");
        postOrder = br.readLine().split(" ");
        br.close();

        solution();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
