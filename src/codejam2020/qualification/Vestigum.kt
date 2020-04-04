package codejam2020.qualification

fun main() {
    val inputFileName = "src/codejam2020/qualification/Vestigum.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val matrix = Array(readLine()!!.toInt()) {
            readLine()!!.split(' ').map { it.toInt() }.toIntArray()
        }

        val trace = matrix.mapIndexed { index, row -> row[index] }.sum()
        val rows = matrix.filter { row -> row.toSet().size != row.size }.count()
        val cols = matrix.indices.count { matrix.map { row -> row[it] }.toSet().size != matrix.size }

        println("Case #$case: $trace $rows $cols")
    }
}
