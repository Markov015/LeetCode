class Solution {
private:
    int n;
    vector<list<int>> adj;
    vector<int> inDegree;
    queue<int> q;
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        n = numCourses;
        adj.resize(n); inDegree.assign(n, 0);
        for (auto& v : prerequisites) {
            adj[v[0]].push_back(v[1]);
            ++inDegree[v[1]];
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.push(i);
            }
        }
        int cnt = 0;
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            ++cnt;
            for (int v : adj[u]) {
                if (--inDegree[v] == 0) {
                    q.push(v);
                }
            }
        }
        return cnt == n;
    }
};
