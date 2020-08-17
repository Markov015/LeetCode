class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>( (x, y) -> y - x);
        for (int num : nums) {
            sum += num;
            pq.add(num);
        }
        int tempSum = 0;
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty() && tempSum <= sum) {
            int t = pq.remove();
            tempSum += t;
            sum -= t;
            list.add(t);
        }
        return list;
    }
}
