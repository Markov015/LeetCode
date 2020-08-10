class Solution {
    public int longestAwesome(String s) {
        int n = s.length();
        boolean[][] odd = new boolean[10][n + 1];
        for (int i = 1; i <= n; i++) {
            int t = s.charAt(i - 1) - '0';
            odd[t][i] = !odd[t][i - 1];
            for (int j = 0; j < 10; j++) {
                if (t != j) odd[j][i] = odd[j][i - 1];
            }
        }
        for (int i = n; i >= 1; i--) {
            for (int begin = 0; begin <= n - i; begin++) {
                if (isAwesome(begin, begin + i, odd)) return i;
            }
        }
        return 1;
    }
    public boolean isAwesome(int left, int right, boolean[][] odd) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (odd[i][right] ^ odd[i][left]) ++count;
        }
        return count <= 1;
    }
}

class Solution {
    public int longestAwesome(String s) {
        int n = s.length();
        int[][] counts = new int[10][n + 1];
        for (int i = 1; i <= n; i++) {
            int t = s.charAt(i) - '0';
            counts[t][i] = counts[t][i - 1] + 1;
            for (int j = 0; j < 10; j++) {
                if (t != j) counts[j][i] = counts[j][i - 1];
            }
        }
    }
    public boolean isAwesome(String s, int left, int right, int[][] counts) {
        int odd = 0;
        for (int i = 0; i < 10; i++) {
            if ((counts[i][right] - counts[i][left]) % 2 == 1) ++odd;
        }
        return odd <= 1;
    }
}

class Solution {
    public int longestAwesome(String s) {
        int n = s.length();
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j < n - i + 1; j++) {
                if (isAwesome(s.substring(j, j + i))) return i;
            }
        }
        return 1;
    }

    public boolean isAwesome(String s) {
        int[] counts = new int[10];
        for (char ch : s.toCharArray()) {
            ++counts[ch - '0'];
        }
        int odd = 0;
        for (int count : counts) {
            if (count % 2 == 1) ++odd;
        }
        return odd <= 1;
    }
}
