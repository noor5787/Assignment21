package in.ineuron3;
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class DoublyLinkedListNode {
    int value;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    DoublyLinkedListNode(int value) {
        this.value = value;
        prev = null;
        next = null;
    }
}

public class BinaryTreeToDoublyLinkedList {
    TreeNode root;
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;

    public void convertBinaryTreeToDoublyLinkedList(TreeNode node) {
        if (node == null)
            return;

        convertBinaryTreeToDoublyLinkedList(node.left);

        DoublyLinkedListNode newNode = new DoublyLinkedListNode(node.value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        convertBinaryTreeToDoublyLinkedList(node.right);
    }

    public void printDoublyLinkedList() {
        DoublyLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTreeToDoublyLinkedList tree = new BinaryTreeToDoublyLinkedList();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(20);
        tree.root.right.left = new TreeNode(30);
        tree.root.right.right = new TreeNode(35);

        tree.convertBinaryTreeToDoublyLinkedList(tree.root);

        System.out.println("Doubly Linked List:");
        tree.printDoublyLinkedList();
    }
}
