package codejam2020.qualification

fun main() {
    val inputFileName = "src/codejam2020/qualification/ParentingPartneringReturns.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val activities = Array(readLine()!!.toInt()) { index ->
            readLine()!!.split(' ').map { it.toInt() }.let { Activity(index, it[0] until it[1]) }
        }

        val timelines = mapOf(
            'C' to mutableSetOf<Int>(),
            'J' to mutableSetOf<Int>()
        )

        val assignment = CharArray(activities.size) { 'X' }

        activities.sortedBy { it.range.start }.forEach { activity ->
            listOf('C', 'J').find { !timelines[it]!!.contains(activity.range.start) }?.let {
                assignment[activity.index] = it
                timelines[it]!!.addAll(activity.range)
            }
        }

        val result = if (assignment.contains('X')) "IMPOSSIBLE" else assignment.joinToString("")
        println("Case #$case: ${result}")
    }
}

data class Activity(val index: Int, val range: IntRange)
