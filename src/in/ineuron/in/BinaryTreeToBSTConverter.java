package in.ineuron.in;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeToBSTConverter {
    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;
    }

    private static void inorderTraversal(TreeNode root, int[] nums, int[] index) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, nums, index);
        root.val = nums[index[0]];
        index[0]++;
        inorderTraversal(root.right, nums, index);
    }

    private static void convertBinaryTreeToBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);

        Collections.sort(values);

        int[] sortedArray = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            sortedArray[i] = values.get(i);
        }

        int[] index = { 0 };
        inorderTraversal(root, sortedArray, index);
    }

    private static void inorderTraversal(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, values);
        values.add(root.val);
        inorderTraversal(root.right, values);
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);

        // Convert the binary tree to a binary search tree
        convertBinaryTreeToBST(root);

        // Print the converted binary search tree
        printInorderTraversal(root);
    }

    private static void printInorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        printInorderTraversal(root.left);
        System.out.print(root.val + " ");
        printInorderTraversal(root.right);
    }
}

