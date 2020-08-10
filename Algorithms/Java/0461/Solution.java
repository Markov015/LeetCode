// int Integer.bitCount(int x)
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}

// 移位
class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if ((xor & 1) != 0) {
                ++distance;
            }
            xor >>= 1;
        }
        return distance;
    }
}

// 移位，每次移除最右边的1
class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            ++distance;
            xor &= xor - 1;
        }
        return distance;
    }
}
