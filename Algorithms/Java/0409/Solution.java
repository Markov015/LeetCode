class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        boolean odd = false;
        int res = 0;
        for (int count : map.values()) {
            res += count;
            if ((count & 0x1) == 1) {
                odd = true;
                --res;
            }
        }
        return odd ? res + 1 : res;
    }
}
