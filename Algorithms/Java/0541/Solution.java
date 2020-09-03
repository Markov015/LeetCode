class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        boolean reverse = true;
        for (int i = 0; i < n; i += k) {
            if (reverse) {
                for (int j = Math.min(i + k - 1, n - 1); j >= i; j--) {
                    sb.append(s.charAt(j));
                }
            } else {
                for (int j = i; j < Math.min(i + k, n); j++) {
                    sb.append(s.charAt(j));
                }
            }
            reverse = !reverse;
        }
        return sb.toString();
    }
}

class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        boolean reverse = true;
        for (int i = 0; i < n; i += k) {
            if (reverse) {
                sb.append(new StringBuffer(s.substring(i, Math.min(i + k, n))).reverse());
            } else {
                sb.append(s.substring(i, Math.min(i + k, n)));
            }
            reverse = !reverse;
        }
        return sb.toString();
    }
}
