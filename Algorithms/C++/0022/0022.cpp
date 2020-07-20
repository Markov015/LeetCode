class Solution {
public:
    vector<string> res;
    vector<string> generateParenthesis(int n) {
        DFS(0, 0, n, "");
        return res;
    }
    void DFS(int nleft, int nright, int n, string t) {
        if(nleft == n && nright == n){
            res.push_back(t);
            return;
        }
        if (nleft < n) {
            DFS(nleft + 1, nright, n, t + "(");
        }
        if (nright < n) {
            if(nright < nleft) {
                DFS(nleft, nright + 1, n, t + ")");
            }
        }
    }
};
