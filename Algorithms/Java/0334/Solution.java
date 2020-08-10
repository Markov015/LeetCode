class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for (int x : nums) {
            if (x <= a) {
                a = x;
            } else if (x <= b) {
                b = x;
            } else {
                return true;
            }
        }
        return false;
    }
}
