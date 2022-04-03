package codejam2022.qualification

fun main() {
    val inputFileName = "src/codejam2022/qualification/d1000000.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        readLine() // n
        val s = readLine()!!.split(' ').map { it.toInt() }
        var res = 0
        s.sorted().forEach { if (it > res) res++ }
        println("Case #$case: $res")
    }
}
