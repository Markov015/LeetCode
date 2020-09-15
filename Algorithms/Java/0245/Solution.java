class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1)) {
                if (!map.containsKey(word1)) {
                    map.put(word1, new ArrayList<Integer>());
                }
                map.get(word1).add(i);
            } else if (words[i].equals(word2)) {
                if (!map.containsKey(word2)) {
                    map.put(word2, new ArrayList<Integer>());
                }
                map.get(word2).add(i);
            }
        }
        if (word1.equals(word2)) {
            List<Integer> list = map.get(word1);
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i < list.size(); i++) {
                ans = Math.min(ans, list.get(i) - list.get(i - 1));
            }
            return ans;
        } else {
            return shortestDistance(map.get(word1), map.get(word2));
        }
    }

    private int shortestDistance(List<Integer> list1, List<Integer> list2) {
        // 给定两个有序列表，返回最小距离
        int ans = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int m = list1.size();
        int n = list2.size();
        while (i < m && j < n) {
            int num1 = list1.get(i), num2 = list2.get(j);
            ans = Math.min(ans, Math.abs(num1 - num2));
            if (num1 < num2) {
                ++i;
            } else {
                ++j;
            }
        }
        return ans;
    }
}
