class Solution {
    public String convertToBase7(int num) {
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(String.valueOf(num % 7));
            num /= 7;
        } while (num != 0);
        return sb.append(negative ? "-" : "").reverse().toString();
    }
}
