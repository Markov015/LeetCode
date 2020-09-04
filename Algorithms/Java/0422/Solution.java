class Solution {
    public boolean validWordSquare(List<String> words) {
        int m = words.size();
        for (int i = 0; i < m; i++) {
            String s = words.get(i);
            for (int j = 0; j < s.length(); j++) {
                String t = words.get(j);
                if (t.length() < i || s.charAt(j) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
