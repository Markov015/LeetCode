/**
* 字符串相加
* num1和num2都只包含数字
* num1和num2都不包含前导零
*/
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + carry;
            sb.append((char)('0' + result % 10));
            carry = result / 10;
            --i;
            --j;
        }
        return sb.reverse().toString();
    }
}
