import java.util.*;

public class B_11725 {
    private static void sortNodes(List<Node> nodeList, int i) {
        Node parentNode = nodeList.get(i);
        if (parentNode.connectNodes.size() == 0) return;

        Iterator iterator = parentNode.connectNodes.iterator();
        while (iterator.hasNext()) {
            int child = (int) iterator.next();

            Node node = nodeList.get(child);
            node.parent = i;
            node.connectNodes.remove(Integer.valueOf(i));

            sortNodes(nodeList, child);
        }
    }

    private static void solution(String[] nodes, int nodeCount) {
        List<Node> nodeList = new ArrayList<>();

        for (int i = 0; i <= nodeCount; i++) {
            nodeList.add(new Node(new ArrayList()));
        }

        for (String n : nodes) {
            String[] nArr = n.split(" ");
            int left = Integer.parseInt(nArr[0]);
            int right = Integer.parseInt(nArr[1]);

            nodeList.get(left).connectNodes.add(right);
            nodeList.get(right).connectNodes.add(left);
        }

        sortNodes(nodeList, 1);

        for (int i = 2; i <= nodeCount; i++) {
            System.out.println(nodeList.get(i).parent);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodeCount = sc.nextInt();
        sc.nextLine();

        String[] nodes = new String[nodeCount - 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = sc.nextLine();
        }
        sc.close();

        solution(nodes, nodeCount);
    }
}

class Node {
    int parent;
    List<Integer> connectNodes;

    Node(List list) {
        this.connectNodes = list;
    }
}
