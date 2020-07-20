class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        var res = new ArrayList<ArrayList<Integer>>();
        // Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                res.add(new ArrayList<Integer>(Arrays.asList(left, right)));
                left = intervals[i][0], right = intervals[i][1];
            }
        }
        res.add(new ArrayList<Integer>(Arrays.asList(left, right)));
        return res.toArray(new int[res.size()]);
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        var res = new ArrayList<int[]>();
        // Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                res.add(new int[] {left, right});
                left = intervals[i][0];
                 right = intervals[i][1];
            }
        }
        res.add(new int[] {left, right});
        return res.toArray(new int[res.size()][]);
    }
}
