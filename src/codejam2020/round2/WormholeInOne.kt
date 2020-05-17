package codejam2020.round2

// TODO
fun main() {
    val inputFileName = "src/codejam2020/round2/WormholeInOne.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        println("Case #$case: OK")
    }
}
