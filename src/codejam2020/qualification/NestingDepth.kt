package codejam2020.qualification

fun main() {
    val inputFileName = "src/codejam2020/qualification/NestingDepth.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val input = readLine()!!
        val result = StringBuilder()
        var prev = 0

        input.filter { it.isDigit() }.map { it.toInt() - 48 }.forEach {
            repeat(it - prev) { result.append('(') }
            repeat(prev - it) { result.append(')') }
            result.append(it)
            prev = it
        }

        repeat(prev) { result.append(')') }
        println("Case #$case: $result")
    }
}
