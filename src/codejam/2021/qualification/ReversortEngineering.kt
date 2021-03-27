package codejam.`2021`.qualification

fun main() {
    val inputFileName = "src/codejam/2021/qualification/ReversortEngineering.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (n, c) = readLine()!!.split(' ').map { it.toInt() }
        val a = IntArray(n) { it + 1 }
        var w = n - 1

        if (w <= c) {
            for (i in n - 2 downTo 0) {
                val x = (n - i - 1).coerceAtMost(c - w)
                w += x
                a.reverse(i, i + x + 1)
            }
        }

        val res = when {
            w == c -> a.toList().joinToString(" ")
            else -> "IMPOSSIBLE"
        }

        println("Case #$case: $res")
    }
}
