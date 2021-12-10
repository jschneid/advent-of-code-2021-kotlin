import kotlin.math.*

fun main() {
    fun calculateGammaRate(diagnosticReport: List<String>): Int {
        val reportEntryLength = diagnosticReport[0].length
        var gammaRateString = ""
        for (i in 0 until reportEntryLength) {
            var zeroes = 0
            for (reportEntry in diagnosticReport) {
                if (reportEntry[i] == '0') {
                    zeroes += 1
                }
            }
            gammaRateString += if (zeroes > diagnosticReport.count() / 2) "0" else "1"
        }
        return gammaRateString.toInt(2)
    }

    fun calculateEpsilonRate(gammaRate: Int, reportEntryLength: Int): Int {
        return ((2.0.pow(reportEntryLength) - 1) - gammaRate).toInt()
    }

    fun part1(diagnosticReport: List<String>): Int {
        val gammaRate = calculateGammaRate(diagnosticReport)
        val epsilonRate = calculateEpsilonRate(gammaRate, diagnosticReport[0].length)
        return gammaRate * epsilonRate
    }

    // test if this implementation returns the correct result for the sample input
    val testInput = readInput("../inputs/Day03_sample")
    check(part1(testInput) == 198)

    val input = readInput("../inputs/Day03")
    println(part1(input))
}
