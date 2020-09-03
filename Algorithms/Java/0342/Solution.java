class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        } else if ((num & (num - 1)) != 0) {
            return false;
        } else {
            int count = 0;
            while (num != 0 && (num & 0x1) == 0) {
                num >>= 1;
                ++count;
            }
            return count % 2 == 0;
        }
    }
}

// 不使用循环或者递归
class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;
    }
}
