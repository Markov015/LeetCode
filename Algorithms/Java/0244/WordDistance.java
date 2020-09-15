class WordDistance {
    private Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; ++i) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        return shortestDistance(map.get(word1), map.get(word2));
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

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
