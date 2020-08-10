class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            int d = (int)(t.charAt(i) - s.charAt(i));
            if (d < 0) d += 26;
            ++count[d];
        }
        int max = 0;
        for (int i = 1; i < 26; i++) {
            if (count[i] > 0) max = Math.max(max, i + 26 * (count[i] - 1));
        }
        return max <= k;
    }
}

class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int d = (int)(t.charAt(i) - s.charAt(i));
            if (d > 0) pq.add(d);
            else if (d < 0) pq.add(d + 26);
        }
        if (pq.size() > k) {
            return false;
        }
        int op = 0;
        while (!pq.isEmpty()) {
            int d = pq.peek();
            if (d > k) {
                break;
            }
            if (d > op) {
                op = d;
            } else {
                pq.add(d + 26);
            }
            pq.remove();
        }
        return pq.isEmpty();
    }
}
