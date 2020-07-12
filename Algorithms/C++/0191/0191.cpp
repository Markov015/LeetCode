class Solution {
public:
    int hammingWeight(uint32_t n) {
        uint32_t mask = 1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (n & mask) {
                ++res;
            }
            mask = mask << 1;
        }
        return res;
    }
};


class Solution {
public:
    int hammingWeight(uint32_t n) {
        int b = 1, res = n & b ? 1 : 0;
        for (int i = 0; i < 31; i++) {
            b = b << 1;
            if (n & b) {
                ++res;
            }
        }
        return res;
    }
};

// class Solution {
// public:
//     int hammingWeight(uint32_t n) {
//         int b = 1, res = 0;
//         while (b) {
//             if (n & b) {
//                 ++res;
//             }
//             b << 1;
//         }
//         return res;
//     }
// };
