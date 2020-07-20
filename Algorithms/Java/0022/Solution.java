class Solution {
    public List<String> generateParenthesis(int n) {
        var res = new ArrayList<String>();
        DFS(res, n, 0, 0, "");
        return res;
    }
    void DFS(List<String> res, int n, int nLeft, int nRight, String t) {
        if (nLeft == n && nRight == n) {
            res.add(t);
            return;
        }
        if (nLeft < n) {
            DFS(res, n, nLeft + 1, nRight, t + "(");
        }
        if (nRight < nLeft) {
            DFS(res, n, nLeft, nRight + 1, t + ")");
        }
    }
}
