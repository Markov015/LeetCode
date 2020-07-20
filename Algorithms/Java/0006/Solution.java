class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String res = "";
        int offset = 2 * (numRows - 1);
        for (int i = 0; i < s.length(); i += offset) {
            res += s.charAt(i);
        }
        for (int row = 1; row < numRows - 1; row++) {
            for (int i = row; i < s.length(); i += offset) {
                res += s.charAt(i);
                int idx = i + 2 * (numRows - 1 - row);
                if (idx < s.length()) {
                    res += s.charAt(idx);
                }
            }
        }
        for (int i = numRows - 1; i < s.length(); i += offset) {
            res += s.charAt(i);
        }
        return res;
    }
}
