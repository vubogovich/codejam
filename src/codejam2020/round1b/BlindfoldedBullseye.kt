package codejam2020.round1b

fun main() {
    val (t, _, _) = readLine()!!.split(' ').map { it.toInt() }
    val m = 1000000000

    for (case in 1..t) {
        var x1 = -m

        while (true) {
            println("$x1 0")
            if (readLine()!! == "HIT") break
            x1++
        }

        var x2 = m

        while (true) {
            println("$x2 0")
            if (readLine()!! == "HIT") break
            x2--
        }

        var y1 = -m

        while (true) {
            println("0 $y1")
            if (readLine()!! == "HIT") break
            y1++
        }

        var y2 = m

        while (true) {
            println("0 $y2")
            if (readLine()!! == "HIT") break
            y2--
        }

        println("${(x1 + x2) / 2} ${(y1 + y2) / 2}")

        if (readLine()!! != "CENTER") throw Error("Oops")
    }
}
