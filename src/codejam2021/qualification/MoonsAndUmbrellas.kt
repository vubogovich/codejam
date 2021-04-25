package codejam2021.qualification

fun main() {
    val inputFileName = "src/codejam2021/qualification/MoonsAndUmbrellas.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (xs, ys, s) = readLine()!!.split(' ')
        val x = xs.toInt()
        val y = ys.toInt()
        val w = s.replace("?", "") // TODO test set 3
        var res = 0

        for (i in 0 until w.length - 1) {
            when {
                w[i] == 'C' && w[i + 1] == 'J' -> res += x
                w[i] == 'J' && w[i + 1] == 'C' -> res += y
            }
        }

        println("Case #$case: $res")
    }
}
