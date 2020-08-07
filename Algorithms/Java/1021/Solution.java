class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        int left = 0, right = 0;
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                if (++left > 1) {
                    stringBuilder.append('(');
                }
            } else {
                ++right;
                if (right < left) {
                    stringBuilder.append(')');
                } else {
                    left = right = 0;
                }
            }
        }
        return stringBuilder.toString();
    }
}
