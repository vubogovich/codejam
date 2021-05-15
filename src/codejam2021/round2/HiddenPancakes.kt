package codejam2021.round2

// TODO
fun main() {
    val inputFileName = "src/codejam2021/round2/HiddenPancakes.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        readLine()!!.split(' ').map { it.toInt() }

        println("Case #$case: OK")
    }
}
