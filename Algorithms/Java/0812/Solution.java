class Solution {
    private int[][] points;

    public double largestTriangleArea(int[][] points) {
        this.points = points;
        int n = points.length;
        double maxArea = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isTraingle(i, j, k)) {
                        maxArea = Math.max(maxArea, calTriangleArea(i, j, k));
                    }
                }
            }
        }
        return maxArea;
    }

    private boolean isTraingle(int i, int j, int k) {
        double a = calDistance(i, j);
        double b = calDistance(j, k);
        double c = calDistance(k, i);
        if (a + b > c && a + c > b && b + c > a) {
            return true;
        } else {
            return false;
        }
    }

    private double calTriangleArea(int i, int j, int k) {
        double a = calDistance(i, j);
        double b = calDistance(j, k);
        double c = calDistance(k, i);
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private double calDistance(int i, int j) {
        return Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) +
            Math.pow(points[i][1] - points[j][1], 2));
    }
}
