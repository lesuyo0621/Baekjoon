import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class B_1991 {
    static class Node {
        String data;
        Node left, right;

        public Node(String data) {
            this.data = data;
            left = right = null;
        }
    }

    private static Map<String, Node> nodeMap = new HashMap<>();
    private static StringBuilder sb = new StringBuilder();

    private static void printOrder(Node node, String direction) {
        if (node == null) return;

        switch (direction) {
            case "pre":
                sb.append(node.data);
                printOrder(node.left, direction);
                printOrder(node.right, direction);
                break;
            case "in":
                printOrder(node.left, direction);
                sb.append(node.data);
                printOrder(node.right, direction);
                break;
            case "post":
                printOrder(node.left, direction);
                printOrder(node.right, direction);
                sb.append(node.data);
                break;
        }
    }

    private static void solution() {
        printOrder(nodeMap.get("A"), "pre");
        sb.append("\n");
        printOrder(nodeMap.get("A"), "in");
        sb.append("\n");
        printOrder(nodeMap.get("A"), "post");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < nodeCount; i++) {
            String[] nodeInfos = br.readLine().split(" ");

            Node root = nodeMap.getOrDefault(nodeInfos[0], new Node(nodeInfos[0]));

            if (!nodeInfos[1].equals(".")) {
                if (!nodeMap.containsKey(nodeInfos[1])) {
                    nodeMap.put(nodeInfos[1], new Node(nodeInfos[1]));
                }

                root.left = nodeMap.get(nodeInfos[1]);
            }

            if (!nodeInfos[2].equals(".")) {
                if (!nodeMap.containsKey(nodeInfos[2])) {
                    nodeMap.put(nodeInfos[2], new Node(nodeInfos[2]));
                }

                root.right = nodeMap.get(nodeInfos[2]);
            }

            nodeMap.put(nodeInfos[0], root);
        }
        br.close();

        solution();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
