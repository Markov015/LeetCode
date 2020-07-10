class Solution {
public:
    int myAtoi(string str) {
        if (str.empty()) {
            return 0;
        }

        // 去掉前导空格以及数字之后的多余字符
        int start = 0, end = str.length();
        while (start < str.length() && str[start] == ' ') {
            start++;
        }
        if (start == end) {
            return 0;
        }

        // 去掉符号并判断正负（如果有符号的话）
        bool negative = false;
        if (str[start] == '+') {
            start++;
        } else if(str[start] == '-') {
            negative = true;
            start++;
        }
        if (start == end) {
            return 0;
        }

        end = start;
        while (end < str.length() && isdigit(str[end])) {
            end++;
        }
        if (start < end) {
            str = str.substr(start, end - start);
        } else {
            return 0;
        }

        // 转换为数值
        int val = 0;
        for (int i = 0; i < str.length(); i++) {
            int t = str[i] - '0';
            if (!negative) {
                if (val < INT_MAX / 10 || (val == INT_MAX / 10 && t <= 7)) {
                    val = val * 10 + t;
                } else {
                    val = INT_MAX;
                    break;
                }
            } else {
                t = -t;
                if (val > INT_MIN / 10 || (val == INT_MIN / 10 && t >= -8)) {
                    val = val * 10 + t;
                } else {
                    val = INT_MIN;
                    break;
                }
            }
        }
        return val;
    }
};
