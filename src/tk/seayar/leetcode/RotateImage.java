package tk.seayar.leetcode;

/**
 * @author wupeng
 * Create on 1/3/19.
 * @version 1.0
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int tmp;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j < (n - 1 - i); j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }

}
