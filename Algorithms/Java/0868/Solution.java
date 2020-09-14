class Solution {
    public int binaryGap(int N) {
        int res = 0;
        int pre = -1;
        for (int i = 0; i < 31; i++) {
           if ((N & 0x1) != 0) {
               if (pre != -1) {
                  res = Math.max(res, i - pre);
               }
               pre = i;
           }
           N >>= 1;
        }
        return res;
    }
}
