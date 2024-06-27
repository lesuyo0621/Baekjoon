import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B_1967 {
    static class Node {
        int num;
        int distance;

        public Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }

    private static List<Node>[] nodeList;
    private static boolean[] visited;
    private static int maxLength = 0;
    private static int maxLengthNode = 0;

    private static void bfs(int root) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));
        visited[root] = true;

        while (!q.isEmpty()) {
            Node parent = q.poll();

            if (maxLength < parent.distance) {
                maxLength = parent.distance;
                maxLengthNode = parent.num;
            }

            List<Node> childNodeList = nodeList[parent.num];
            for (int i = 0; i < childNodeList.size(); i++) {
                Node child = childNodeList.get(i);

                if (!visited[child.num]) {
                    q.add(new Node(child.num, parent.distance + child.distance));
                    visited[child.num] = true;
                }
            }
        }
    }

    private static void solution(int nodeCount) {
        visited = new boolean[nodeCount + 1];
        bfs(1);

        visited = new boolean[nodeCount + 1];
        maxLength = 0;
        bfs(maxLengthNode);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());

        nodeList = new ArrayList[nodeCount + 1];
        for (int i = 0 ; i < nodeCount + 1; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < nodeCount - 1; i++) {
            String[] arr = br.readLine().split(" ");
            int root = Integer.parseInt(arr[0]);
            int next = Integer.parseInt(arr[1]);
            int distance = Integer.parseInt(arr[2]);

            nodeList[root].add(new Node(next, distance));
            nodeList[next].add(new Node(root, distance));
        }
        br.close();

        solution(nodeCount);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(maxLength));
        bw.flush();
        bw.close();
    }
}
