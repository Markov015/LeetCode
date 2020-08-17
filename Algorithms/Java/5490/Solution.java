class Solution {
    public int minDays(int n) {
        if (n == 1) {
            return 1;
        } else if (n % 2 == 0 && n % 3 == 0) {
            return Math.min(minDays(n - 1), Math.min(minDays(n / 2), minDays(n / 3))) + 1;
        } else if (n % 2 == 0) {
            return Math.min(minDays(n - 1), minDays(n / 2)) + 1;
        } else if (n % 3 == 0) {
            return Math.min(minDays(n - 1), minDays(n / 3)) + 1;
        } else {
            return minDays(n - 1) + 1;
        }
    }
}

class Solution {
    public int minDays(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(1); set.add(1);
        int count = 0;
        int t;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++count;
            for (int i = 0; i < size; i++) {
                t = queue.remove();
                if (t == n) {
                    return count;
                } else {
                    int x = t * 3;
                    if (x <= n && !set.contains(x)) {
                        queue.add(x);
                        set.add(x);
                    }
                    x = t * 2;
                    if (x <= n && !set.contains(x)) {
                        queue.add(x);
                        set.add(x);
                    }
                    x = t + 1;
                    if (x <= n && !set.contains(x)) {
                        queue.add(t + 1);
                        set.add(x);
                    }
                }
            }
        }
        return count;
    }
}

class Solution {
    public int minDays(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
    }
}
