import java.math.BigInteger;

class Solution {
    public String multiply(String num1, String num2) {
           BigInteger b1 = new BigInteger(num1);
           BigInteger b2 = new BigInteger(num2);
           return b1.multiply(b2).toString();
    }
}

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }
        String res = "0";
        int n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            res = add(res, multiply(num1, num2.charAt(i)));
            num1 = num1 + "0";
        }
        return res;
    }

    private String multiply(String num, Character ch) {
        if (ch == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int i = num.length() - 1, carry = 0;
        int y = ch - '0';
        while (i >= 0 || carry != 0) {
            int x = i >= 0 ? num.charAt(i) - '0' : 0;
            int result = x * y + carry;
            sb.append((char)('0' + result % 10));
            carry = result / 10;
            --i;
        }
        return sb.reverse().toString();
    }

    private String add(String num1, String num2) {
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
