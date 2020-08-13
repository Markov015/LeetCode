class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        // map[num]存储num在数组B中最后一次出现的索引
        Map<Integer, Integer> map = new HashMap<>();
        int n = A.length;
        int[] C = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = map.getOrDefault(A[i], -1) + 1; j < n; j++) {
                if (B[j] == A[i]) {
                    map.put(A[i], j);
                    C[i] = j;
                    break;
                }
            }
        }
        return C;
    }
}
