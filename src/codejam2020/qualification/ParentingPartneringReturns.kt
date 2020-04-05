package codejam2020.qualification

fun findOption(activities: Array<IntRange>, timelineC: MutableSet<Int>, timelineJ: MutableSet<Int>, assignment: CharArray): Boolean {
    val index = assignment.indexOf(' ')
    if (index < 0) return true

    if (!activities[index].any { timelineC.contains(it) }) {
        timelineC.addAll(activities[index])
        assignment[index] = 'C'
        if (findOption(activities, timelineC, timelineJ, assignment)) return true
        assignment[index] = ' '
        timelineC.removeAll(activities[index])
    }

    if (!activities[index].any { timelineJ.contains(it) }) {
        timelineJ.addAll(activities[index])
        assignment[index] = 'J'
        if (findOption(activities, timelineC, timelineJ, assignment)) return true
        assignment[index] = ' '
        timelineJ.removeAll(activities[index])
    }

    return false
}

fun main() {
    val inputFileName = "src/codejam2020/qualification/ParentingPartneringReturns.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val activities = Array(readLine()!!.toInt()) {
            readLine()!!.split(' ').map { it.toInt() }.let { it[0] until it[1] }
        }

        val timelineC = mutableSetOf<Int>()
        val timelineJ = mutableSetOf<Int>()
        val assignment = CharArray(activities.size) { ' ' }
        val exists = findOption(activities, timelineC, timelineJ, assignment)
        val result = if (exists) assignment.joinToString("") else "IMPOSSIBLE"
        println("Case #$case: ${result}")
    }
}
