package codejam2022.round1c

fun main() {
    val inputFileName = "src/codejam2022/round1c/LetterBlocks.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        readLine() // n = towers.length
        val towers = readLine()!!.split(' ').toMutableList()

        for (i in towers.size - 1 downTo 0) {
            if (towers[i].toSet().size == 1) {
                for (j in 0 until towers.size) {
                    if (i != j) {
                        if (towers[i].first() == towers[j].last()) {
                            towers[j] += towers[i]
                            towers.removeAt(i)
                            break
                        } else if (towers[i].last() == towers[j].first()) {
                            towers[j] = towers[i] + towers[j]
                            towers.removeAt(i)
                            break
                        }
                    }
                }
            }
        }

        for (i in towers.size - 1 downTo 0) {
            for (j in 0 until towers.size) {
                if (i != j) {
                    if (towers[i].first() == towers[j].last()) {
                        towers[j] += towers[i]
                        towers.removeAt(i)
                        break
                    } else if (towers[i].last() == towers[j].first()) {
                        towers[j] = towers[i] + towers[j]
                        towers.removeAt(i)
                        break
                    }
                }
            }
        }

        var megaTower = towers.joinToString("")

        for (i in 1 until megaTower.length) {
            val previous = megaTower.lastIndexOf(megaTower[i], i - 1)

            if (previous in 0..i - 2) {
                megaTower = "IMPOSSIBLE"
                break
            }
        }

        println("Case #$case: $megaTower")
    }
}
