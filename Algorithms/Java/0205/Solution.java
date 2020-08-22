class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            char ch2 = t.charAt(i);
            if (!map.containsKey(ch)) {
                if (set.contains(ch2)) {
                    return false;
                } else {
                     map.put(ch, ch2);
                     set.add(ch2);
                }
            } else {
                if (map.get(ch) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (!map.containsKey(ch1)) {
                if (map.values().contains(ch2)) {
                    return false;
                } else {
                     map.put(ch1, ch2);
                }
            } else {
                if (map.get(ch1) != ch2) {
                    return false;
                }
            }
        }
        return true;
    }
}
