
/**
 * DFS: 超时
 */
// class Solution {
//     private String res;
//     private boolean[] visit;
//     private int n;
//     private int k;
//     private int count = 0;
//
//     public String getPermutation(int n, int k) {
//         this.n = n;
//         this.k = k;
//         visit = new boolean[n + 1];
//         for (int i = 1; i <= n; i++) {
//              dfs(i, "");
//         }
//         return res;
//     }
//
//     private void dfs(int curr, String temp) {
//         visit[curr] = true;
//         temp += String.valueOf(curr);
//         if (temp.length() == n) {
//             if (++count == k) {
//                 res = temp;
//                 return;
//             }
//         }
//         for (int i = 1; i <= n; i++) {
//             if (!visit[i]) {
//                 dfs(i, temp);
//             }
//         }
//         temp = temp.substring(0, temp.length() - 1);
//         visit[curr] = false;
//     }
// }
