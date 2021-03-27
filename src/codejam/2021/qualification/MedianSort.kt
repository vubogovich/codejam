package codejam.`2021`.qualification

fun main() {
    val inputFileName = "src/codejam/2021/qualification/MedianSort.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    val (t, n, q) = readLine()!!.split(' ').map { it.toInt() }

    for (case in 1..t) {
        val r = mutableListOf(mutableListOf(1), mutableListOf(2))
        // TODO
        println("Case #$case: OK")
    }
}

//1?2?3?4?5?6
//
//1 2 3
//
//1. 2 1 3
//   1 3 4
//   1. 2?4 1 3
//      1 3 5
//	  1. 2?4?5 1 3
//	  3. 2?4 1 3 5
//	  5. 2?4 1 5 3
//
//   3. 2 1 3 4
//      1 3 5
//	  1. 2?5 1 3 4
//	  3. 2 1 3 4?5
//	  5. 2 1 5 3 4
//
//   4. 2 1 4 3
//      1 4 5
//	  1. 2?5 1 4 3
//	  4. 2 1 4 5?3
//	  5. 2 1 5 4 3
//	     2 1 6
//		 2. 6 2 1 5 4 3
//		 1. 2 1 6?(5 4 3)
//		    6 5 4
//			6. 2 1 5 6 4 3
//			5. 2 1 6 5 4 3
//			4. 2 1 5 4 6?3
//		 6. 2 6 1 5 4 3
//
//
//2. 1 2 3
//3. 1 3 2
