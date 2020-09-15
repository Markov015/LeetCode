class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> mapA = wordCount(A);
        Map<String, Integer> mapB = wordCount(B);
        List<String> list = new ArrayList<>();
        for (String word : mapA.keySet()) {
            if (mapA.get(word) == 1 && !mapB.containsKey(word)) {
                list.add(word);
            }
        }
        for (String word : mapB.keySet()) {
            if (mapB.get(word) == 1 && !mapA.containsKey(word)) {
                list.add(word);
            }
        }
        return list.isEmpty() ? new String[0] : list.toArray(new String[0]);
    }

    private Map<String, Integer> wordCount(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : s.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }
}
