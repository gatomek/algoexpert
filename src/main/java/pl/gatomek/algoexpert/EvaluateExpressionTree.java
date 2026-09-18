package pl.gatomek.algoexpert;

public class EvaluateExpressionTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    int evaluateExpressionTree(BinaryTree tree) {
        return postOrderCalc(tree);
    }

    int postOrderCalc(BinaryTree tree) {
        boolean isOperator = tree.value < 0;
        if (isOperator) {
            int a = postOrderCalc(tree.left);
            int b = postOrderCalc(tree.right);

            return switch(tree.value) {
                case -1 -> a+b;
                case -2 -> a-b;
                case -3 -> a/b;
                case -4 -> a*b;
                default -> throw new IllegalStateException("unknown operator");
            };
        }
        else {
            return tree.value;
        }
    }
}
