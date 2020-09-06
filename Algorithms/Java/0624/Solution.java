class Solution {
    public int maxDistance(List<List<Integer>> lists) {
        int res = 0;
        List<Integer> list = lists.get(0);
        int minVal = list.get(0);
        int maxVal = list.get(list.size() - 1);
        for (int i = 1; i < lists.size(); i++) {
            list = lists.get(i);
            int left = list.get(0);
            int right = list.get(list.size() - 1);
            res = Math.max(res, Math.max(Math.abs(maxVal - left), Math.abs(minVal - right)));
            minVal = Math.min(minVal, left);
            maxVal = Math.max(maxVal, right);
        }
        return res;
    }
}
