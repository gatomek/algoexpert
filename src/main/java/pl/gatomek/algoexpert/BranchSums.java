package pl.gatomek.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    public static List<Integer> branchSums(BinaryTree root) {
        return preOrderTraverse(root);
    }

    private static List<Integer> preOrderTraverse(BinaryTree tree) {
        if (tree.left == null && tree.right == null) {
            return List.of(tree.value);
        }

        List<Integer> collector = new ArrayList<>();

        if (tree.left != null) {
            List<Integer> leftList = preOrderTraverse(tree.left);
            collector.addAll(leftList);
        }

        if (tree.right != null) {
            List<Integer> rightList = preOrderTraverse(tree.right);
            collector.addAll(rightList);
        }

        for (int i = 0; i < collector.size(); i++) {
            collector.set(i, collector.get(i) + tree.value);
        }

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
