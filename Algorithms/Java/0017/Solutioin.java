class Solution {
    public List<String> res;
    public List<List<String>> map = new ArrayList<>(){
        {}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
        {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    public List<String> letterCombinations(String digits) {
        if (digits =! null && !digits.isEmpty()) {
            DFS(digits, 0, "");
        }
        return res;
    }
    public void DFS(String digits, int i, String t) {
        if (i == digits.length()) {
            res.add(t);
        }
        for (char ch : map.get(digits.charAt(i) - '0')) {
            DFS(digits, i + 1, t + ch);
        }
    }
}
