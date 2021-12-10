fun main() {
    fun parseInstruction(inputLine: String): Instruction {
        val splitInstruction: List<String> = inputLine.split(" ")
        return Instruction(splitInstruction[0], splitInstruction[1].toInt())
    }

    fun updatePosition(instruction: Instruction, position: Position) {
        when (instruction.command) {
            "forward" -> {
                position.horizontalPosition += instruction.value
                position.depth += instruction.value * position.aim
            }
            "down" -> position.aim += instruction.value
            "up" -> position.aim -= instruction.value
        }
    }

    fun part2(inputLines: List<String>): Int {
        val position = Position()
        for (inputLine in inputLines) {
            val instruction: Instruction = parseInstruction(inputLine)
            updatePosition(instruction, position)
        }
        return position.horizontalPosition * position.depth
    }

    // test if this implementation returns the correct result for the sample input
    val testInput = readInput("../inputs/Day02_sample")
    check(part2(testInput) == 900)

    val input = readInput("../inputs/Day02")
    println(part2(input))
}
