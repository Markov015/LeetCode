class Solution {
    public int countSegments(String s) {
        s = s.trim();
        return "".equals(s) ? 0 : s.split("\\s+").length;
    }
}
