fun main(args: Array<String>) {   
    partOne()
    partTwo()
}

fun partOne() {
    var num2 = 0
    var num3 = 0
	for (id in input) {
        if (id.toCharArray().groupBy{ it }.any{ it.value.size == 2 }) {
            num2 ++
        }
        
        if (id.toCharArray().groupBy{ it }.any{ it.value.size == 3 }) {
            num3 ++
        }
    }
    
    println(num2 * num3)
}

fun partTwo() {
	for (id1 in input) {
        for (id2 in input) { 
            var correct = ""
            var numIncorrect = 0
            for (i: Int in 0..id1.length-1) {
                if (id1.get(i) == id2.get(i)) {
                    correct += (id1.get(i))
                } else {
                    numIncorrect++
                    if (numIncorrect > 1) {
                        break
                    }
                }
            }
            
            if (numIncorrect == 1) {
                println(correct)
                return
            }
        }
    }
}
