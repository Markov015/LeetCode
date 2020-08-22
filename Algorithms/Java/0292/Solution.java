class Solution {
    public boolean canWinNim(int n) {
        return n == 1 ? true : n % 4 != 0;
    }
}
