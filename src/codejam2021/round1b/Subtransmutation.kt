package codejam2021.round1b

import java.lang.Math.min

fun main() {
    val inputFileName = "src/codejam2021/round1b/Subtransmutation.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (n, a, b) = readLine()!!.split(' ').map { it.toInt() }
        val u = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
        val max = 1000
        var res = n

        while (res <= max) {
            val w = Array(res + 1) { if (it < n) -u[it] else 0 }
            w[res] = 1

            var pos = res

            while (pos >= 0 && w[pos] >= 0) {
                if (w[pos] > 0) {
                    if (pos - a >= 0) w[pos - a] = min(max, w[pos - a] + w[pos])
                    if (pos - b >= 0) w[pos - b] = min(max, w[pos - b] + w[pos])
                }

                pos--
            }

            res++

            if (pos < 0) break
        }

        when {
            res <= max -> println("Case #$case: $res")
            else -> println("Case #$case: IMPOSSIBLE")
        }
    }
}
