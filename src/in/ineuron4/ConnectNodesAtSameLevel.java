package in.ineuron4;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;
    Node nextRight;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.nextRight = null;
    }
}

public class ConnectNodesAtSameLevel {
    public static void connectNodes(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr != null) {
                curr.nextRight = queue.peek();

                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            } else if (!queue.isEmpty()) {
                queue.offer(null);
            }
        }
    }

    public static void printNextRight(Node root) {
        if (root == null)
            return;

        Node curr = root;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.nextRight;
        }
        System.out.println("-1");

        if (root.left != null)
            printNextRight(root.left);
        else if (root.right != null)
            printNextRight(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        connectNodes(root);
        printNextRight(root);
    }
}
