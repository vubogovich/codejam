package codejam2020.qualification

operator fun IntRange.times(target: IntRange): Boolean =
    (this.start < target.endInclusive) && (this.endInclusive > target.start)

fun main() {
    val inputFileName = "src/codejam2020/qualification/ParentingPartneringReturns.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val activities = Array(readLine()!!.toInt()) {
            readLine()!!.split(' ').map { it.toInt() }.let { it[0]..it[1] }
        }

        val assignment = CharArray(activities.size) { 'C' }
        var pos = 1
        var proposed = 'C'

        while (pos < activities.size) {
            var target = activities
                .filterIndexed { index, _ -> (index < pos) && (assignment[index] == proposed) }
                .indexOfFirst { it * activities[pos] }

            if ((target >= 0) && (proposed == 'C')) {
                proposed = 'J'

                target = activities
                    .filterIndexed { index, _ -> (index < pos) && (assignment[index] == proposed) }
                    .indexOfFirst { it * activities[pos] }
            }

            assignment[pos] = proposed

            if (target < 0) {
                pos++
                proposed = 'C'
            } else if (assignment[target] == 'C') {
                pos = target
                proposed = 'J'
            } else {
                pos = Int.MAX_VALUE // impossible
            }
        }

        val result = if (pos > activities.size) "IMPOSSIBLE" else assignment.joinToString("")
        println("Case #$case: ${result}")
    }
}
