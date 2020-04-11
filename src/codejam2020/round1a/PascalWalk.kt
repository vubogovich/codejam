package codejam2020.round1a

import java.lang.Integer.min

fun main() {
    val inputFileName = "src/codejam2020/round1a/PascalWalk.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    val rows = Array(50) { LongArray(it + 1) { 1 } }

    for (r in 1 until rows.size) {
        for (k in 1 until r) rows[r][k] = rows[r - 1][k - 1] + rows[r - 1][k]
        if (rows[r].any { it < 0 }) throw Error("Exceed long capacity")
    }

    for (case in 1..readLine()!!.toInt()) {
        var sum = readLine()!!.toInt()

        val result = mutableListOf<Pair<Int, Int>>()
        var row = min(sum, rows.size) - 1

        while (row > 0) {
            var k = 1
            sum -= 2
            result.add(row to 0)

            while ((k <= row) && (sum - rows[row][k] >= row - 1)) {
                result.add(row to k)
                sum -= rows[row][k].toInt()

                if ((k < row) && (sum - rows[row - 1][k] >= row - 1)) {
                    sum -= rows[row - 1][k].toInt()
                    k++
                } else {
                    break
                }
            }

            if (k > 1) {
                for (i in k - 1 downTo 0) result.add(row - 1 to i)
                row -= 2
            } else {
                sum++
                row--
            }
        }

        if (row == 0) result.add(0 to 0)

        println("Case #$case:")

        result.reversed().forEach { println("${it.first + 1} ${it.second + 1}") }
    }
}
