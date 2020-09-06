class Solution {
    public int[] constructRectangle(int area) {
        for (int W = (int)Math.sqrt(area); W > 0; W--) {
            if (area % W == 0) {
                return new int[] {area / W, W};
            }
        }
        return null;
    }
}
