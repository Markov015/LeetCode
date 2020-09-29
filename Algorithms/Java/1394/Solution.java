class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            if (num == map.get(num)) {
                return num;
            }
        }
        return -1;
    }
}

class Solution {
    public int findLucky(int[] arr) {
        int[] cnt = new int[501];
        for (int num : arr) {
            ++cnt[num];
        }
        for (int i = 500; i > 0; --i) {
            if (i == cnt[i]) {
                return i;
            }
        }
        return -1;
    }
}
