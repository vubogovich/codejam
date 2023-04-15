package codejam2023.a

fun main() {
    val inputFileName = "src/codejam2023/a/CollidingEncoding.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val d = readLine()!!.split(' ').map { it[0] }.toCharArray()
        val n = readLine()!!.toInt()
        val set = mutableSetOf<String>()

        (0 until n).forEach {
            set.add(String(readLine()!!.map { d[it - 'A'] }.toCharArray()))
        }

        println("Case #$case: ${if (set.size < n) "YES" else "NO"}")
    }
}
