class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int n = word.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : abbr.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (sb.length() == 0 && ch == '0') {
                    return false;
                }
                sb.append(ch);
            } else {
                if (sb.length() > 0) {
                    i += Integer.valueOf(sb.toString());
                    sb.delete(0, sb.length());
                }
                if (i >= n || ch != word.charAt(i)) {
                    return false;
                } else {
                    ++i;
                }
            }
        }
        if (sb.length() > 0) {
            i += Integer.valueOf(sb.toString());
            sb.delete(0, sb.length());
        }
        return i == n;
    }
}
