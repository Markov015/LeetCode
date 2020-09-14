class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return isPointInRectangle(rec1, new int[] {rec2[0], rec2[1]}) ||
            isPointInRectangle(rec1, new int[] {rec2[0], rec2[3]}) ||
            isPointInRectangle(rec1, new int[] {rec2[2], rec2[1]}) ||
            isPointInRectangle(rec1, new int[] {rec2[2], rec2[3]});
    }

    private boolean isPointInRectangle(int[] rect, int[] point) {
        return rect[0] < point[0] && point[0] < rect[2] &&
            rect[1] < point[1] && point[1] < rect[3];
    }
}
