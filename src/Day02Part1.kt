data class Instruction(val command:String, val value: Int)
data class Position(var horizontalPosition: Int = 0, var depth: Int = 0)

fun main() {
    fun parseInstruction(inputLine: String): Instruction {
        val splitInstruction: List<String> = inputLine.split(" ")
        return Instruction(splitInstruction[0], splitInstruction[1].toInt())
    }

    fun updatePosition(instruction: Instruction, position: Position) {
        when (instruction.command) {
            "forward" -> position.horizontalPosition += instruction.value
            "down" -> position.depth += instruction.value
            "up" -> position.depth -= instruction.value
        }
    }

    fun part1(inputLines: List<String>): Int {
        val position = Position()
        for (inputLine in inputLines) {
            val instruction: Instruction = parseInstruction(inputLine)
            updatePosition(instruction, position)
        }
        return position.horizontalPosition * position.depth
    }

    // test if this implementation returns the correct result for the sample input
    val testInput = readInput("../inputs/Day02_sample")
    check(part1(testInput) == 150)

    val input = readInput("../inputs/Day02")
    println(part1(input))
}
