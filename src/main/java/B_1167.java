import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class B_1167 {
    static class Node {
        int num;
        int distance;

        public Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }

    private static List<Node>[] list;
    private static boolean[] visited;
    private static int maxLength = 0;
    private static int maxLengthNode = 0;

    private static void parsingNodeInfo(String[] nodeInfos) {
        for (String info : nodeInfos) {
            String[] nArr = info.split(" ");
            int index = Integer.parseInt(nArr[0]);
            list[index] = new ArrayList<>();

            for (int i = 1; i < nArr.length; i += 2) {
                int num = Integer.parseInt(nArr[i]);
                if (num == -1) break;

                int d = Integer.parseInt(nArr[i + 1]);
                list[index].add(new Node(num, d));
            }
        }
    }

    private static void dfs(int root, int len) {
        if (maxLength < len) {
            maxLength = len;
            maxLengthNode = root;
        }

        visited[root] = true;

        List<Node> next = list[root];
        for (int i = 0; i < next.size(); i++) {
            Node nextNode = next.get(i);

            if (!visited[nextNode.num]) {
                dfs(nextNode.num, len + nextNode.distance);
            }
        }
    }

    private static void solution(int nodeCount, String[] nodeInfos) {
        list = new ArrayList[nodeCount + 1];
        parsingNodeInfo(nodeInfos);

        visited = new boolean[nodeCount + 1];
        dfs(1, 0);

        visited = new boolean[nodeCount + 1];
        dfs(maxLengthNode, 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());

        String[] nodeInfos = new String[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            nodeInfos[i] = br.readLine();
        }
        br.close();

        solution(nodeCount, nodeInfos);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(maxLength));
        bw.flush();
        bw.close();
    }
}
