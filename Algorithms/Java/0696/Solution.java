class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int index = 0, last = 0;
        int ans = 0;
        while (index < n) {
            char ch = s.charAt(index);
            int count = 0;
            while (index < n && s.charAt(index) == ch) {
                ++index;
                ++count;
            }
            ans += Math.min(last, count);
            last = count;
        }
        return ans;
    }
}

// 时间复杂度O(n)
// 空间复杂度O(n)
class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        List<Integer> counts = new ArrayList<>();
        int index = 0;
        while (index < n) {
            char ch = s.charAt(index);
            int count = 0;
            while (index < n && s.charAt(index) == ch) {
                ++index;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }
}
