class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        boolean res = false;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                String t = s.substring(0, i);
                boolean flag = true;
                for (int j = i; j < n; j += i) {
                    if (!t.equals(s.substring(j, j + i))) {
                        flag = false;
                    }
                }
                if (flag == true) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }
}
