// DFS 回溯法
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> vec = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        res.add(new ArrayList<>(vec));
        for (int i = 0; i < n; i++) {
            DFS(i, nums);
        }
        return res;
    }

    private void DFS(int i, int[] nums) {
        vec.add(nums[i]);
        res.add(new ArrayList<>(vec));
        for (int j = i + 1; j < nums.length; j++) {
            DFS(j, nums);
        }
        vec.remove(vec.size() - 1);
    }
}

// 递归
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            for (int i = 0; i < res.size(); i++) {
                res.add(new ArrayList<>(res.get(i)){{add(num);}})
            }
        }
        return res;
    }
}
