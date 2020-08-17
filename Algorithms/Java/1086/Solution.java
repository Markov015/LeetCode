// 小顶堆
class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap();
        for (int[] item : items) {
            if (!map.contains(item[0])) {
                map.put(item[0], new PriorityQueue<>());
            }
            PriorityQueue<Integer> pq = map.get(item[0]);
            if (pq.size() == 5) {
                if (pq.peek() < item[1]) {
                    pq.remove();
                    pq.add(item[1]);
                }
            } else {
                pq.add(item[1]);
            }
        }
        int[][] res = new int[map.keySet().size()][2];
        int index = 0;
        for (Integer key : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(key);
            int sum = 0;
            while (!pq.isEmpty()) {
                sum += pq.poll();
            }
            int[index] = {key, sum / 5};
        }
        return res;
    }
}
