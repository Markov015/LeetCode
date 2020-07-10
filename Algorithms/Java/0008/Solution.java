class Solution {
public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        // 去掉前导空格以及数字之后的多余字符
        int start = 0, end = str.length();
        while (start < end && str.charAt(start) == ' ') {
            start++;
        }
        if (start == end) {
            return 0;
        }

        // 去掉符号并判断正负（如果有符号的话）
        Boolean negative = false;
        if (str.charAt(start) == '+') {
            start++;
        } else if(str.charAt(start) == '-') {
            negative = true;
            start++;
        }
        if (start == end) {
            return 0;
        }

        end = start;
        while (end < str.length() && Character.isDigit(str.charAt(end))) {
            end++;
        }
        if (start < end) {
            str = str.substring(start, end - start);
        } else {
            return 0;
        }

        // 转换为数值
        int val = 0;
        for (int i = 0; i < str.length(); i++) {
            int t = str.charAt(i) - '0';
            if (negative == false) {
                if (val < Integer.MAX_VALUE / 10 || (val == Integer.MAX_VALUE / 10 && t <= 7)) {
                    val = val * 10 + t;
                } else {
                    val = Integer.MAX_VALUE;
                    break;
                }
            } else {
                t = -t;
                if (val > Integer.MIN_VALUE / 10 || (val == Integer.MIN_VALUE / 10 && t >= -8)) {
                    val = val * 10 + t;
                } else {
                    val = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        return val;
    }
};
