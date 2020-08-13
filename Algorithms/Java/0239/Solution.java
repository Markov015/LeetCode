/**
 * 滑动窗口最大值
 * 暴力法
 * 时间复杂度: O(nk)
 * 空间复杂度: O(n)
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int t = 0; t + k <= n; t++) {
            res[t] = getMax(nums, t, t + k);
        }
        return res;
    }

    /**
     * 线性扫描法求数组nums[left ... right)的最大值
     * @param nums 数组
     * @param left 数组左边界（包含）
     * @param right 数组右边界（不包含）
     * @return 数组的最大值
     */
    private int getMax(int[] nums, int left, int right) {
        int max = nums[left];
        for (int i = left + 1; i < right; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}

/**
 * 滑动窗口最大值
 * 双端队列
 * 时间复杂度: O(n)
 * 空间复杂度: O(k)
 */
class Solution {
    private Deque<Integer> deque = new LinkedList<>();
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        initQueue(nums, k);
        for (int i = k - 1; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            int left = i - k + 1;
            while (deque.getFirst() < left) {
                deque.removeFirst();
            }
            res[left] = nums[deque.getFirst()];
        }
        return res;
    }

    private void initQueue(int[] nums, int k) {
        for (int i = 0; i < k - 1; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
    }
}

/**
 * 动态规划
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int n = nums.length;
        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        int[] res = new int[n - k + 1];
        for (int i = 1; i < n; i++) {
            left[i] = i % (k - 1) == 0 ? nums[i] : Math.max(left[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = (i + 1) % (k - 1) == 0 ? nums[i] :Math.max(right[i + 1], nums[i]);
        }
        for (int i = 0; i < n - k + 1; i++) {
            res[i] = Math.max(left[i + k - 1], right[i]);
        }
        return res;
    }
}
