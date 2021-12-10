fun main() {
    fun part2(depths: List<Int>): Int {
        var increases = 0
        for(i in 3 until depths.count()) {
            if (depths[i-3] < depths[i]) {
                increases += 1
            }
        }
        return increases
    }

    // test if this implementation returns the correct result for the sample input
    val testInput = readInputLinesAsInts("../inputs/Day01_sample")
    check(part2(testInput) == 5)

    val input = readInputLinesAsInts("../inputs/Day01")
    println(part2(input))
}
