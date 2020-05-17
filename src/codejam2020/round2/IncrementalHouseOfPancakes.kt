package codejam2020.round2

import java.lang.Math

fun main() {
    val inputFileName = "src/codejam2020/round2/IncrementalHouseOfPancakes.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        var (left, right) = readLine()!!.split(' ').map { it.toLong() }
        val diff = Math.abs(left - right)

        var l = 0L
        var r = Int.MAX_VALUE.toLong()

        while (l < r) {
            val m = (l + r + 1) / 2

            if ((m + 1) * m / 2 > diff) {
                r = m - 1
            } else {
                l = m
            }
        }

        val n = l

        ((n + 1) * n / 2).let {
            if (right > left) {
                right -= it
            } else {
                left -= it
            }
        }

        val min = Math.min(left, right)
        val max = Math.max(left, right)

        l = 0
        r = Int.MAX_VALUE.toLong()

        while (l < r) {
            val m = (l + r + 1) / 2

            val minc = m / 2
            val maxc = (m + 1) / 2

            val minp = (n + minc + 1) * minc
            val maxp = (n + maxc) * maxc

            if ((minp > min) || (maxp > max)) {
                r = m - 1
            } else {
                l = m
            }
        }

        val minf = l / 2
        val maxf = (l + 1) / 2

        val mind = (n + minf + 1) * minf
        val maxd = (n + maxf) * maxf

        if (right > left) {
            right -= maxd
            left -= mind
        } else {
            left -= maxd
            right -= mind
        }

        println("Case #$case: ${n + l} $left $right")
    }
}
