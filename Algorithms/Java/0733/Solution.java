class Solution {
    private int m;
    private int n;
    private int[][] image;
    private int[] R = {0, -1, 0, 1};
    private int[] C = {1, 0, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.m = image.length;
        this.n = image[0].length;
        this.image = image;
        bfs(sr, sc, newColor);
        return this.image;
    }

    private void bfs(int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (newColor == oldColor) {
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sr, sc});
        while (!queue.isEmpty()) {
            int[] coordinate = queue.remove();
            int r = coordinate[0], c = coordinate[1];
            image[r][c] = newColor;
            for (int i = 0; i < 4; i++) {
                int row = r + R[i];
                int col = c + C[i];
                if (0 <= row && row < m && 0 <= col && col < n && image[row][col] == oldColor) {
                    queue.add(new int[] {row, col});
                }
            }
        }
    }
}
