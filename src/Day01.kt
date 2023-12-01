fun main() {
    fun part1(input: List<String>): Int {
        return input.map {
            it.filter { c -> c.isDigit() }
        }.map {
            "${it.first()}${it.last()}"
        }.sumOf {
            it.toInt()
        }
    }

    fun part2(input: List<String>): Int {
        return input.map {
            it.replace("one", "one1one")
                .replace("two", "two2two")
                .replace("three", "three3three")
                .replace("four", "four4four")
                .replace("five", "five5five")
                .replace("six", "six6six")
                .replace("seven", "seven7seven")
                .replace("eight", "eight8eight")
                .replace("nine", "nine9nine")
        }.let {
            part1(it)
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)
    val testInput2 = readInput("Day01_test2")
    check(part2(testInput2) == 281)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
