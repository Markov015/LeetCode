class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private int n;
    private int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        for (int i = 1; i <= n; i++) {
            dfs(0, i);
        }
        return res;
    }

    private void dfs(int depth, int curr) {
        list.add(curr);
        if (++depth == k) {
            res.add(List.copyOf(list));
            list.remove(list.size() - 1);
            return;
        }
        for (int i = curr + 1; i <= n; i++) {
            dfs(depth, i);
        }
        list.remove(list.size() - 1);
    }
}
