fun main() {
    fun part1(depths: List<Int>): Int {
        var increases = 0
        for ((i, depth) in depths.withIndex()) {
            if (i == 0) continue
            if (depths[i-1] < depth) {
                increases += 1
            }
        }
        return increases
    }

    // test if this implementation returns the correct result for the sample input
    val testInput = readInputLinesAsInts("../inputs/Day01_sample")
    check(part1(testInput) == 7)

    val input = readInputLinesAsInts("../inputs/Day01")
    println(part1(input))
}
