class Solution {
    public int maximum69Number (int num) {
        return Integer.valueOf(String.valueOf(num).replaceFirst("6", "9"));
    }
}

class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder();
        boolean find = false;
        for (char ch : String.valueOf(num).toCharArray()) {
            if (find || ch == '9') {
                sb.append(ch);
            } else {
                sb.append(9);
                find = true;
            }
        }
        return new Integer(sb.toString()).intValue();
    }
}
