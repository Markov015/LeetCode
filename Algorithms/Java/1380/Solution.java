class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m]; // row[i]表示第i行最小元素的列索引
        int[] col = new int[n]; // col[j]表示第j列最大元素的行索引
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < matrix[i][row[i]]) {
                    row[i] = j;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] > matrix[col[j]][j]) {
                    col[j] = i;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (i == col[row[i]]) {
                list.add(matrix[i][row[i]]);
            }
        }
        return list;
    }
}
