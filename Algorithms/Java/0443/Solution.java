class Solution {
    public int compress(char[] chars) {
        int j = 0;
        int count = 1;
        int n = chars.length;
        for (int i = 1; i < n; i++) {
            if (chars[i] == chars[i - 1]) {
                ++count;
            } else {
                chars[j++] = chars[i - 1];
                Stack<Character> stack = new Stack<>();
                while (count != 0) {
                    stack.push((char)('0' + count % 10));
                    count /= 10;
                }
                while (!stack.isEmpty()) {
                    chars[j++] = stack.peek();
                }
            }
        }
        chars[j++] = chars[n - 1];
        Stack<Character> stack = new Stack<>();
        while (count != 0) {
            stack.push((char)('0' + count % 10));
            count /= 10;
        }
        while (!stack.isEmpty()) {
            chars[j++] = stack.peek();
        }
        return j + 1;
    }
}
