fun main(args: Array<String>) {
    partOne()
    partTwo()
}

fun partOne() {
    print(input.map{ it.toInt() }.sum())
}

fun partTwo() {
    val reached: MutableSet<Int> = mutableSetOf(0)
    var current = 0
    var found = false
    
    while (!found) {
        for (x in input) {
            val num = x.toInt()
            current += num
            if (reached.contains(current)) {
                print("\n$current")
                found = true
                break  
            }
            reached.add(current)
        }
    }
}
