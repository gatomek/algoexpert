package pl.gatomek.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    public static List<Integer> branchSums(BinaryTree root) {
        return postOrderTraverse(root);
    }

    private static List<Integer> postOrderTraverse(BinaryTree tree) {
        if (tree.left == null && tree.right == null) {
            return List.of(tree.value);
        }

        List<Integer> collector = new ArrayList<>();

        if (tree.left != null) {
            List<Integer> leftList = postOrderTraverse(tree.left);
            collector.addAll(leftList);
        }

        if (tree.right != null) {
            List<Integer> rightList = postOrderTraverse(tree.right);
            collector.addAll(rightList);
        }

        collector.replaceAll(integer -> integer + tree.value);
        return collector;
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
