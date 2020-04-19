package codejam2020.round1b

import kotlin.math.abs

fun main() {
    val inputFileName = "src/codejam2020/round1b/Expogo.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        var (x, y) = readLine()!!.split(' ').map { it.toInt() }

        var result = StringBuilder()

        while ((x != 0) || (y != 0)) {
            val ax = abs(x)
            val ay = abs(y)

            if (ax and 1 == ay and 1) {
                result = StringBuilder("IMPOSSIBLE")
                break
            }

            if (((ax > 1) || (ay > 1)) && (ax and 2 == ay and 2)) {
                if (ax and 1 > 0) {
                    result.append(if (x < 0) 'E' else 'W')
                    x += if (x > 0) 1 else -1
                } else {
                    result.append(if (y < 0) 'N' else 'S')
                    y += if (y > 0) 1 else -1
                }
            } else if (ax and 1 > 0) {
                result.append(if (x > 0) 'E' else 'W')
            } else {
                result.append(if (y > 0) 'N' else 'S')
            }

            x /= 2
            y /= 2
        }

        println("Case #$case: $result")
    }
}
