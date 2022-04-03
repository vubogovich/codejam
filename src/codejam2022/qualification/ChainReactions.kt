package codejam2022.qualification

import java.lang.Math.max

fun main() {
    val inputFileName = "src/codejam2022/qualification/ChainReactions.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val n = readLine()!!.toInt()
        val f = readLine()!!.split(' ').map { it.toInt() }.toMutableList()
        val p = readLine()!!.split(' ').map { it.toInt() }.toMutableList()
        val b = Array(n) { mutableListOf<Int>() }

        f.indices.reversed().forEach { index ->
            if (p[index] > 0) {
                b[p[index] - 1].add(index)
            }

            b[index].minByOrNull { f[it] }?.also { min ->
                b[index].forEach {
                    if (it == min) {
                        f[index] = max(f[index], f[it])
                    } else {
                        p[it] = 0
                    }
                }
            }
        }

        val max = f.filterIndexed { index, _ -> p[index] == 0 }.map { it.toLong() }.sum()

        println("Case #$case: $max")
    }
}
