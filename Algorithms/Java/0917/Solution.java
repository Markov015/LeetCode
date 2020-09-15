class Solution {
    public String reverseOnlyLetters(String s) {
        int left = 0, right = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while (left < right) {
            while (left < right && !Character.isLetter(sb.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetter(sb.charAt(right))) {
                --right;
            }
            if (left < right) {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);
                ++left;
                --right;
            }
        }
        return sb.toString();
    }
}

class Solution {
    public String reverseOnlyLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
