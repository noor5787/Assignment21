package in.ineuron2;

class Node {
    int value;
    Node left, right;

    public Node(int item) {
        value = item;
        left = right = null;
    }
}

class BST {
    Node root;

    public int findDistance(Node node, int key) {
        if (node == null)
            return -1;
        if (node.value == key)
            return 0;
        if (key < node.value)
            return 1 + findDistance(node.left, key);
        return 1 + findDistance(node.right, key);
    }

    public int findDistanceBetweenNodes(int node1, int node2) {
        return findDistanceBetweenNodes(root, node1, node2);
    }

    private int findDistanceBetweenNodes(Node node, int node1, int node2) {
        if (node == null)
            return -1;

        if (node.value > node1 && node.value > node2)
            return findDistanceBetweenNodes(node.left, node1, node2);

        if (node.value < node1 && node.value < node2)
            return findDistanceBetweenNodes(node.right, node1, node2);

        if (node.value >= node1 && node.value <= node2)
            return findDistance(node, node1) + findDistance(node, node2);

        return -1; // Return -1 if any of the nodes is not found
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.root = new Node(8);
        bst.root.left = new Node(3);
        bst.root.right = new Node(10);
        bst.root.left.left = new Node(1);
        bst.root.left.right = new Node(6);
        bst.root.left.right.left = new Node(4);
        bst.root.left.right.right = new Node(7);
        bst.root.right.right = new Node(14);
        bst.root.right.right.left = new Node(13);

        int node1 = 6;
        int node2 = 14;
        int distance = bst.findDistanceBetweenNodes(node1, node2);

        System.out.println("The distance between the two keys = " + distance);
    }
}
