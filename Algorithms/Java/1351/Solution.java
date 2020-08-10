// 暴力解法
// 时间复杂度O(mn)
class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) ++count;
            }
        }
        return count;
    }
}

// 二分查找
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            count += n - binarySearch(grid[i], 0, n - 1);
        }
        return count;
    }

    public int binarySearch(int[] arr, int left, int right) {
        // 返回arr[left...right)中第一个负数的索引
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (arr[mid] >= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
