// 暴力求解
class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        // rowCount[i]记录第i行的黑色像素的数量
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    ++rowCount[i];
                    ++colCount[j];
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) {
                    ++count;
                }
            }
        }
        return count;
    }
}
