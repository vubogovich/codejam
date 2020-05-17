package codejam2020.round2

// TODO test set 2
fun main() {
    val inputFileName = "src/codejam2020/round2/SecurityUpdates.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (_, d) = readLine()!!.split(' ').map { it.toInt() }
        val x = listOf(0, 0) + readLine()!!.split(' ').map { -it.toInt() }

        Array(d) { readLine()!!.split(' ').map { it.toInt() }. let { it[0] to it[1] } }
            .map { Math.max(1, Math.abs(x[it.first] - x[it.second])) }
            .joinToString(" ")
            .let { println("Case #$case: $it") }
    }
}
