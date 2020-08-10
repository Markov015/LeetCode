class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> mapTarget = new HashMap<>();
        Map<Integer, Integer> mapArr = new HashMap<>();
        for (int num : target) {
            mapTarget.put(num, mapTarget.getOrDefault(num, 0) + 1);
        }
        for (int num : arr) {
            mapArr.put(num, mapArr.getOrDefault(num, 0) + 1);
        }
        return mapTarget.equals(mapArr);
    }
}
