package codejam2023.a

fun main() {
    val inputFileName = "src/codejam2023/a/AsciiArt.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        var n = readLine()!!.toLong()
        var i = 1

        while (i * 26 < n) {
            n -= i * 26
            i++
        }

        val res = Char(((n - 1) / i).toInt() + 'A'.code)

        println("Case #$case: $res")
    }
}
