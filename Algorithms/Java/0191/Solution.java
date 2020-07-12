public class Solution {
    public int hammingWeight(int n) {
        int b = 1, res = (n & b) != 0 ? 1 : 0;
        for (int i = 0; i < 31; i++) {
            b = b << 1;
            if ((n & b) != 0) {
                ++res;
            }
        }
        return res;
    }
}
