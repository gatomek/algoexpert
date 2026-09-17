package pl.gatomek.algoexpert;

class FindClosestValueInBST {
    static int findClosestValueInBst(BST tree, int target) {
        final int currValue = tree.value;
        if (currValue == target) {
            return currValue;
        }

        if (target < currValue) {
            if (tree.left != null) {
                final int candidate = findClosestValueInBst(tree.left, target);
                int currDelta = Math.abs(target - currValue);
                int candDelta = Math.abs(target - candidate);
                return currDelta < candDelta ? currValue : candidate;
            } else {
                return currValue;
            }
        } else {
            if (tree.right != null) {
                final int candidate = findClosestValueInBst(tree.right, target);
                int currDelta = Math.abs(target - currValue);
                int candDelta = Math.abs(target - candidate);
                return currDelta < candDelta ? currValue : candidate;
            } else {
                return currValue;
            }
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
