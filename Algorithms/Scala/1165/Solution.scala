object Solution {
    def calculateTime(keyboard: String, word: String): Int = {
        var res : Int = 0
        var map : Map[Char, Int] = Map()
        for (i <- 0 to keyboard.length - 1) {
            map += (keyboard.charAt(i) -> i)
        }
        var last = 0
        for (ch <- word) {
            res += math.abs(map(ch) - last)
            last = map(ch)
        }
        res
    }
}
