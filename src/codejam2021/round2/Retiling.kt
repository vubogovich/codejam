package codejam2021.round2

import kotlin.math.abs

// TODO
fun main() {
    val inputFileName = "src/codejam2021/round2/Retiling.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (r, c, f, s) = readLine()!!.split(' ').map { it.toInt() }
        val now = Array(r) { readLine()!!.toCharArray() }
        val target = Array(r) { readLine()!!.toCharArray() }
        val mq = mutableSetOf<Pair<Int, Int>>()
        val gq = mutableSetOf<Pair<Int, Int>>()
        var cost = 0L

        for (i in 0 until r) {
            for (j in 0 until c) {
                when {
                    now[i][j] == 'G' && target[i][j] == 'M' -> mq.add(i to j)
                    now[i][j] == 'M' && target[i][j] == 'G' -> gq.add(i to j)
                }
            }
        }

        mq.forEach { (x, y) ->
            gq.mapNotNull { (i, j) ->
                (abs(x - i) + abs(y - j))
                    .takeIf { it > 0 }
                    ?.let { (i to j) to it }
            }
                .filter { (_, d) -> d * s < f * 2 }
                .minByOrNull { (_, d) -> d }
                ?.let { (p, d) -> gq.remove(p).also { cost += d * s } }
                ?: run { cost += f }
        }

        gq.forEach { _ -> cost += f }

        println("Case #$case: $cost")
    }
}
