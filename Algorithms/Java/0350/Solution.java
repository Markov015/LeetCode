// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         Map<Integer, Integer> map1 = new HashMap<>();
//         Map<Integer, Integer> map2 = new HashMap<>();
//         for (int num : nums1) {
//             if (map1.containsKey(num)) {
//                 map1.put(num, map1.get(num) + 1);
//             } else {
//                 map1.put(num, 1);
//             }
//         }
//         for (int num : nums2) {
//             if (map2.containsKey(num)) {
//                 map2.put(num, map2.get(num) + 1);
//             } else {
//                 map2.put(num, 1);
//             }
//         }
//         List<Integer> list = new ArrayList<>();
//         for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
//             for (int i = 0; i < Math.min(entry.getValue(), map2.get(entry.getKey())); i++) {
//                 list.add(entry.getValue());
//             }
//         }
//         return (int [])list.toArray(new int[list.size()]);
//     }
// }
