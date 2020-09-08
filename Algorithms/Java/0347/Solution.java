class Pair implements Comparable<Pair>{
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        return o.second - this.second;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            pq.add(new Pair(key, map.get(key)));
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove().first;
        }
        return res;
    }
}
