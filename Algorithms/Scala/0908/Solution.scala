object Solution {
    def smallestRangeI(A: Array[Int], K: Int): Int = {
        var (max, min) = (Integer.MIN_VALUE, Integer.MAX_VALUE)
        for (x <- A) {
            max = Math.max(max, x)
            min = Math.min(min, x)
        }
        return Math.max(max - min - 2 * K, 0)
    }
}

object Solution {
    def smallestRangeI(A: Array[Int], K: Int): Int = {
        var (min, max) = (Int.MaxValue, Int.MinValue)
        for (x <- A) {
            min = min.min(x)
            max = max.max(x)
        }
        math.max(max - min - 2 * K, 0)
    }
}

object Solution {
    def smallestRangeI(A: Array[Int], K: Int): Int = {
        math.max(A.max - A.min - 2 * K, 0)
    }
}
