class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, i = -1;
        for (int j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) > 0) {
                while (s.charAt(++i) != s.charAt(j)) {
                    map.put(s.charAt(i), 0);
                }
            } else {
                map.put(s.charAt(j), 1);
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}
