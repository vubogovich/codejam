package codejam2023.a

fun main() {
    val inputFileName = "src/codejam2023/a/Untie.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val c = readLine()!!.toMutableList()

        var res = 0

        var f = 1
        while (f < c.size && c[f] == c[0]) f++

        if (f > 2 && f % 2 > 0) {
            c[1] = 'A'
            res++
        }

        for (i in 0 until c.size) {
            val prev = if (i > 0) c[i - 1] else c[c.size - 1]
            val next = if (i < c.size - 1) c[i + 1] else c[0]

            if (c[i] == prev && c[i] == next) {
                c[i] = 'A'
                res++
            }
        }

        for (i in 0 until c.size) {
            val prev = if (i > 0) c[i - 1] else c[c.size - 1]

            if (c[i] == prev) {
                c[i] = 'B'
                res++
            }
        }

        println("Case #$case: $res")
    }
}
