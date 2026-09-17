package pl.gatomek.algoexpert;

public class NodeDepths {
    static int nodeDepths(BinaryTree root) {
        return preOrderTraverse(root, 0);
    }

    static int preOrderTraverse(BinaryTree node, int level) {
        int currentLevel = level;

        if(node.left != null) {
            currentLevel += preOrderTraverse(node.left, level + 1);
        }

        if(node.right != null) {
            currentLevel += preOrderTraverse(node.right, level + 1);
        }

        return currentLevel;
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
