package pl.gatomek.algoexpert;

public class NodeDepths {

    private NodeDepths() {
    }

    static int nodeDepths(BinaryTree root) {
        return preOrderTraverse(root, 0);
    }

    static int preOrderTraverse(BinaryTree node, int level) {
        int currentTotal = level;

        if (node.left != null) {
            currentTotal += preOrderTraverse(node.left, level + 1);
        }

        if (node.right != null) {
            currentTotal += preOrderTraverse(node.right, level + 1);
        }

        return currentTotal;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
