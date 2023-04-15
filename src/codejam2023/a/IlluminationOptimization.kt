package codejam2023.a

fun main() {
    val inputFileName = "src/codejam2023/a/IlluminationOptimization.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (m, r) = readLine()!!.split(' ').map { it.toInt() }
        val x = readLine()!!.split(' ').map { it.toInt() }

        var l = 0
        var xi = 0
        var res = 0

        while (l < m && xi < x.size && x[xi] - r <= l) {
            while (xi < x.size - 1 && x[xi + 1] - r <= l) xi++
            l = x[xi] + r
            xi++
            res++
        }

        if (l < m) {
            println("Case #$case: IMPOSSIBLE")
        } else {
            println("Case #$case: $res")
        }
    }
}
