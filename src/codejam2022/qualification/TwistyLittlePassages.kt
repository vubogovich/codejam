package codejam2022.qualification

// TODO
fun main() {
    val inputFileName = "src/codejam2022/qualification/TwistyLittlePassages.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        readLine()!!.split(' ').map { it.toInt() }

        println("Case #$case: OK")
    }
}
