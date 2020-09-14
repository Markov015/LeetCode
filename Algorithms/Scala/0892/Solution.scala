import java.lang.Math

object Solution {
    def surfaceArea(grid: Array[Array[Int]]): Int = {
        val n = grid.length
        var res = 0
        for (i <- 0 until n; j <- 0 until n) {
            if (grid(i)(j) != 0) {
                res += 2
            }
            if (i > 0) {
                res += Math.abs(grid(i)(j) - grid(i - 1)(j))
            }
            if (j > 0) {
                res += Math.abs(grid(i)(j) - grid(i)(j - 1))
            }
        }
        for (i <- 0 until n) {
            res += grid(i)(0) + grid(i)(n - 1)
        }
        for (j <- 0 until n) {
            res += grid(0)(j) + grid(n - 1)(j)
        }
        return res
    }
}
