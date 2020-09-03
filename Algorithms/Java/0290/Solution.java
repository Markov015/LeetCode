class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<String, Character> map = new HashMap<>();
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            String word = words[i];
            char ch = pattern.charAt(i);
            if (map.containsKey(word)) {
                if (map.get(word) != ch) {
                    return false;
                }
            } else {
                if (map.values().contains(ch)) {
                    return false;
                }
                map.put(word, ch);
            }
        }
        return true;
    }
}
