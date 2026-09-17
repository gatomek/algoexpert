package pl.gatomek.algoexpert;

public class TransposeMatrix {
    public int[][] transposeMatrix(int[][] matrix) {
        final int cols = matrix.length;
        final int rows = matrix[0].length;

        int[][] transposition = new int[rows][];
        for (int i = 0; i < rows; i++) {
            transposition[i] = new int[cols];
        }

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                final int value = matrix[c][r];
                transposition[r][c] = value;
            }
        }

        return transposition;
    }
}
