package codejam2020.round1a

// TODO test set 3
fun main() {
    val inputFileName = "src/codejam2020/round1a/PatternMatching.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val patterns = Array(readLine()!!.toInt()) { readLine()!!.split('*').let { it[0] to it[1] } }

        val left = patterns.map { it.first }.maxByOrNull { it.length }!!
        val right = patterns.map { it.second }.maxByOrNull { it.length }!!
        val ok = patterns.all { left.startsWith(it.first) && right.endsWith(it.second) }
        val result = if (ok) left + right else "*"

        println("Case #$case: $result")
    }
}
