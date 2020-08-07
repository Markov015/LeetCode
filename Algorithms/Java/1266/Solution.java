import static java.lang.Math.*;

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for (int i = 0; i < points.length - 1; i++) {
            time += minTime(points[i], points[i + 1]);
        }
        return time;
    }

    public int minTime(int[] p1, int[] p2) {
        return max(abs(p1[0] - p2[0]), abs(p1[1] - p2[1]));
    }
}
