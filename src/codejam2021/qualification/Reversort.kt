package codejam2021.qualification

fun main() {
    val inputFileName = "src/codejam2021/qualification/Reversort.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val n = readLine()!!.toInt()
        val pos = IntArray(n + 1)
        var res = 0

        readLine()!!.split(' ').forEachIndexed { index, s -> pos[s.toInt()] = index + 1 }

        for (i in 1 until n) {
            val j = pos[i]
            res += j - i + 1

            for (k in i..n) {
                if (pos[k] <= j) pos[k] = j - pos[k] + i
            }
        }

        println("Case #$case: $res")
    }
}
