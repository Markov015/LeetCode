import java.util.Collection;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return gcd(map.values()) >= 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int gcd(Collection<Integer> collection) {
        int ans = 0;
        Iterator<Integer> iter = collection.iterator();
        while(iter.hasNext()) {
            ans = gcd(ans, iter.next());
        }
        return ans;
    }
}
