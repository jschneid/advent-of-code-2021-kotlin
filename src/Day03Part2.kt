fun main() {
    fun mostCommonValueAtPosition(diagnosticReport: List<String>, position: Int): Char {
        var zeroes = 0
        var ones = 0

        for (reportLine in diagnosticReport) {
            if (reportLine[position] == '0') zeroes += 1 else ones += 1
        }

        return if (ones >= zeroes) '1' else '0'
    }

    fun leastCommonValueAtPosition(diagnosticReport: List<String>, position: Int): Char {
        return if (mostCommonValueAtPosition(diagnosticReport, position) == '1') '0' else '1'
    }

    fun calculateRating(diagnosticReport: List<String>, commonValueFunction: (diagnosticReport: List<String>, position: Int) -> Char): String {
        val ratingCandidates = diagnosticReport.toMutableList()

        for (position in 0 until diagnosticReport[0].length) {
            if (ratingCandidates.count() == 1) break

            val commonValue = commonValueFunction(ratingCandidates, position)
            ratingCandidates.retainAll { it[position] == commonValue }
        }
        return ratingCandidates[0]
    }

    fun part2(diagnosticReport: List<String>): Int {
        val oxygenGeneratorRating = calculateRating(diagnosticReport, ::mostCommonValueAtPosition)
        val co2ScrubberRating = calculateRating(diagnosticReport, ::leastCommonValueAtPosition)
        return oxygenGeneratorRating.toInt(2) * co2ScrubberRating.toInt(2)
    }

    // test if this implementation returns the correct result for the sample input
    val testInput = readInput("../inputs/Day03_sample")
    check(part2(testInput) == 230)

    val input = readInput("../inputs/Day03")
    println(part2(input))
}
