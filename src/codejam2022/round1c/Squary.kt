package codejam2022.round1c

// TODO test set 2
fun main() {
    val inputFileName = "src/codejam2022/round1c/Squary.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val ( _, k) = readLine()!!.split(' ').map { it.toInt() }
        val e = readLine()!!.split(' ').map { it.toLong() }
        val s = e.sum()
        val sq = e.sumOf { it * it }

        if (k > 1) throw Error("Not implemented")

        val res = when {
            s * s == sq -> 0L
            s != 0L && (sq - s * s) % (s * 2) == 0L -> (sq - s * s) / (s * 2)
            else -> null
        }

        println("Case #$case: ${res?.toString() ?: "IMPOSSIBLE"}")
    }
}
