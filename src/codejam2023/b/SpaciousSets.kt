package codejam2023.b

// TODO test set 2
fun main() {
    val inputFileName = "src/codejam2023/b/SpaciousSets.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (n, k) = readLine()!!.split(' ').map { it.toInt() }
        val sa = readLine()!!.split(' ').mapIndexed { index, it -> index to it.toInt() }.sortedBy { it.second }
        val a = sa.map { it.second }

        val maxAfter = Array(n) { 1 }
        val maxBefore = Array(n) { 1 }

        for (i in 0 until n - 1) {
            var l = i + 1
            var r = n - 1

            while (l < r) {
                val m = (l + r + 1) / 2

                if (a[m] <= a[i] + k) {
                    l = m
                } else {
                    r = m - 1
                }
            }

            if (a[l] < a[i] + k) l++

            for (j in l until n) {
                if (maxBefore[i] + 1 > maxBefore[j]) {
                    maxBefore[j] = maxBefore[i] + 1
                }

//                if (a[j] - k > a[i] + k) break
            }
        }

        for (i in n - 1 downTo 1) {
            var l = 0
            var r = i - 1

            while (l < r) {
                val m = (l + r + 1) / 2

                if (a[m] <= a[i] - k) {
                    l = m
                } else {
                    r = m - 1
                }
            }

            if (a[l] > a[i] - k) l--

            for (j in l downTo 0) {
                if (maxAfter[i] + 1 > maxAfter[j]) {
                    maxAfter[j] = maxAfter[i] + 1
                }

//                if (a[j] + k < a[i] - k) break
            }
        }

        val res = Array(n) { 0 }
        sa.forEachIndexed { i, (index, _) -> res[index] = maxBefore[i] + maxAfter[i] - 1 }

        println("Case #$case: ${res.joinToString(" ")}")
    }
}
