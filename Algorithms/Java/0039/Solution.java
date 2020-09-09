class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        dfs(candidates, target, 0, temp, res);
        return res;
    }

    private void dfs(int[] candidates, int target, int index, List<Integer> temp,  List<List<Integer>> res) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(List.copyOf(temp));
            return;
        }
        if (candidates[index] <= target) {
            temp.add(candidates[index]);
            dfs(candidates, target - candidates[index], index, temp, res);
            temp.remove(temp.size() - 1);
        }
        dfs(candidates, target, index + 1, temp, res);
    }
}
