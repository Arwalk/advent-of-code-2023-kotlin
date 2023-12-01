fun main() {

    fun solver(finder : (String) -> (List<Int>)) : (input: List<String>) -> (Int) {
        return { input: List<String> ->
            input.map(finder).sumOf {
                (it.first() * 10) + it.last()
            }
        }
    }

    val part1 = solver {
        return@solver it.filter {
            c -> c.isDigit()
        }.map { c -> c.toString().toInt() }
    }

    fun findAllOccAndMap(str: String, v: Int) : (String) -> List<Pair<Int, Int>> {
        return { it ->
            val collected = mutableListOf<Pair<Int, Int>>()
            var index = 0
            while(index != -1) {
                index = it.indexOf(str, index).let {i ->
                    if(i != -1) {
                        collected.add(i to v)
                        i+1
                    } else {
                        i
                    }

                }
            }
            collected.toList()
        }
    }

    val namesAndValues = listOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
    )

    val part2 = solver { str ->
        val simpleDigits = str.mapIndexedNotNull {
            i, c -> if(c.isDigit()) {
                i to c.toString().toInt()
            } else {
                null
            }
        }
        val complexes = namesAndValues.map {nv ->
            findAllOccAndMap(nv.first, nv.second)(str)
        }.flatten()

        (simpleDigits + complexes)
            .sortedBy { it.first }
            .map { it.second }
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
