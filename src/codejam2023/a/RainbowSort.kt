package codejam2023.a

fun main() {
    val inputFileName = "src/codejam2023/a/RainbowSort.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        readLine()
        val s = readLine()!!.split(' ').map { it.toInt() }
        val set = mutableSetOf<Int>()
        val res = mutableListOf<Int>()

        for (i in s.indices) {
            if (i > 0 && s[i] == s[i - 1]) continue

            if (set.contains(s[i])) {
                res.clear()
                break
            }

            set.add(s[i])
            res.add(s[i])
        }

        if (res.isEmpty()) {
            println("Case #$case: IMPOSSIBLE")
        } else {
            println("Case #$case: ${res.joinToString(" ")}")
        }
    }
}
