package codejam2022.round1c

// TODO
fun main() {
    val inputFileName = "src/codejam2022/round1c/Intranets.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        readLine()!!.split(' ').map { it.toInt() }

        println("Case #$case: OK")
    }
}
