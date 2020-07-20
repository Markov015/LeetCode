class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> dp = new ArrayList<>(triangle.size());
        dp.add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            dp.add(i, dp.get(i-1) + triangle.get(i).get(i));
            for (int j = i - 1; j > 0; j--) {
                dp.set(j, Math.min(dp.get(j-1), dp.get(j)) + triangle.get(i).get(j));
            }
            dp.set(0, dp.get(0) + triangle.get(i).get(0));
        }
        return Collections.min(dp);
    }
}
