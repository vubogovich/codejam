package codejam2021.round2

// TODO
fun main() {
    val inputFileName = "src/codejam2021/round2/Matrygons.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    fun find(n: Int, t: Int, s: Int): Int {
        if (n < t) return 0
        if (n == t) return 1

        var i = s

        while (i * t < n) {
            val k = find(n - i * t, i * t, 2)
            if (k > 0) return k + 1
            i++
        }

        return if (n == t) 1 else 0
    }

    for (case in 1..readLine()!!.toInt()) {
        val n = readLine()!!.toInt()
        val r = find(n, 1, 3)
        println("Case #$case: $r")
    }
}
