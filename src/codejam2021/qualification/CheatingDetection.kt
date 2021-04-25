package codejam2021.qualification

// TODO
fun main() {
    val inputFileName = "src/codejam2021/qualification/CheatingDetection.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        readLine()!!.split(' ').map { it.toInt() }

        println("Case #$case: OK")
    }
}
