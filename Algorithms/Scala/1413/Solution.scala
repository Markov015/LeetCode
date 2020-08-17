object Solution {
    def minStartValue(nums: Array[Int]): Int = {
        var (sum, min) = (0, Int.MaxValue)
        for (num <- nums) {
            sum += num
            min = math.min(min, sum)
        }
        math.max(1, 1 - min)
    }
}
