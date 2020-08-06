class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxCandies = 0;
        for (int num : candies) {
            maxCandies = Math.max(maxCandies, num);
        }
        List<Boolean> res = new ArrayList<>(n);
        for (int num : candies) {
            res.add(num + extraCandies >= maxCandies);
        }
        return res;
    }
}
