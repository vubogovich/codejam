package codejam2022.qualification

fun main() {
    val inputFileName = "src/codejam2022/qualification/PunchedCards.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (r, c) = readLine()!!.split(' ').map { it.toInt() }

        println("Case #$case:")
        println("..+${"-+".repeat(c - 1)}")
        println("..|${".|".repeat(c - 1)}")

        (1 until r).forEach {
            println("+${"-+".repeat(c)}")
            println("|${".|".repeat(c)}")
        }

        println("+${"-+".repeat(c)}")
    }
}
