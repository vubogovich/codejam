package codejam2022.qualification

import java.lang.Math.min

fun main() {
    val inputFileName = "src/codejam2022/qualification/3dPrinting.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    val target = 1_000_000

    for (case in 1..readLine()!!.toInt()) {
        val mins = Array<Int>(4) { Int.MAX_VALUE }

        (1..3).forEach {
            readLine()!!.split(' ')
                .map { it.toInt() }
                .forEachIndexed { index, value -> mins[index] = min(value, mins[index]) }
        }

        if (mins.sum() < target) {
            println("Case #$case: IMPOSSIBLE")
        } else {
            for (index in 1..3) {
                val res = mins.slice(0..index).sum()
                if (res > target) mins[index] -= res - target
            }

            println("Case #$case: ${mins.joinToString(" ")}")
        }
    }
}
