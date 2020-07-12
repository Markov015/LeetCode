class Solution {
public:
    set<int> vis;
    vector<list<pair<int, double>>> adj;
    vector<double> maxProb;

    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        adj.resize(n);
        maxProb.assign(n, 0.0);
        for (int i = 0; i < edges.size(); i++) {
            vector<int>& edge = edges[i];
            int u = edge[0], v = edge[1];
            adj[u].push_back(make_pair(v, succProb[i]));
            adj[v].push_back(make_pair(u, succProb[i]));
        }
        maxProb[start] = 1.0;
        Dijkstra(n, start, end);
        return maxProb[end];
    }

    void Dijkstra(int n, int src, int dst) {
        for(int i = 0; i < n; i++) {
            int u;
            double tempMaxProb = 0.0;
            for(int v = 0; v < n; v++) {
                if(!vis[v] && maxProb[v] > tempMaxProb) {
                    u = v;
                    tempMaxProb = maxProb[v];
                }
            }
            vis.insert(u);
            if(u == dst) {
                return;
            }
            for(auto& p : adj[u]) {
                int v = p.first;
                double prob = p.second;
                if(!vis[v] && maxProb[u] * prob > maxProb[v]) {
                    maxProb[v] = maxProb[u] * prob;
                    if (maxProb[v] <= maxProb[src]) {
                        vis[v] = true;
                    }
                }
            }
        }
    }
};
