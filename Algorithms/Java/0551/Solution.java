class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        boolean flag = false; // 标记是否出现超过两个连续的L
        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'A': ++countA;
                    break;
                case 'L': if (i > 1 && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
                    flag = true;
                }
                    break;
            }
            if (countA > 1 || flag) {
                return false;
            }
        }
        return true;
    }
}
