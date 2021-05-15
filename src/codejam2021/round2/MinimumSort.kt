package codejam2021.round2

fun main() {
    val inputFileName = "src/codejam2021/round2/MinimumSort.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    val (t, n) = readLine()!!.split(' ').map { it.toInt() }

    for (case in 1..t) {
        for (p in 1 until n) {
            println("M $p $n")

            val i = readLine()!!.toInt()?.takeIf { it > 0 } ?: return

            if (i > p) {
                println("S $p $i")
                if (readLine()!!.toInt() != 1) return
            }
        }

        println("D")
        if (readLine()!!.toInt() != 1) return
    }
}
