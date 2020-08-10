class Solution {
    public int minInsertions(String s) {
        int left = 0, right = 0;
        int res = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // 遇到左括号时还有未匹配的右括号
                if (right == 1) {
                    if (left == 0) res += 2; // 没有未匹配的左括号
                    else {
                        res += 1; // 只需要补一个右括号
                        --left;
                    }
                }
                ++left; right = 0;
            } else { // 遇到了右括号
                if (++right == 2) {
                    if (--left < 0) {
                        left = 0;
                        ++res;
                    }
                    right = 0;
                }
            }
        }
        if (left > 0) {
            return res + left * 2 - right;
        } else if (right == 1) {
            return res + 2;
        } else {
            return res;
        }
    }
}

class Solution {
    public int minInsertions(String s) {
        int left = 0, right = 0;
        int res = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // 遇到左括号时还有未匹配的括号
                res += helper(left, right);
                left = 1; right = 0;
            } else { // 遇到了右括号
                if (++right == 2) {
                    if (--left < 0) {
                        left = 0;
                        ++res;
                    }
                    right = 0;
                }
            }
        }

        return res + helper(left, right);
    }

    public int helper(int left, int right) {
        if (left == 1) {
            return left * 2 - right;
        } else if (right == 1) {
            return 3 - right;
        } else {
            return 0;
        }
    }
}
