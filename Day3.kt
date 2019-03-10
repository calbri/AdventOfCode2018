fun main(args: Array<String>) {
	partOne()
    partTwo()
}

fun partOne() {
    var fabric = HashMap<Pair<Int,Int>, Int>()
    var counter = 0
    
    for (claim in input) {
        val left = Regex("""(\d*)(?=,)""").find(claim)?.value!!.toInt()
        val top = Regex("""(\d*)(?=:)""").find(claim)?.value!!.toInt()        
        val width = Regex("""(\d*)(?=x)""").find(claim)?.value!!.toInt()
        val height = Regex("""(\d*)(?=$)""").find(claim)?.value!!.toInt()
        
        for (x in left..left+width-1) {
            for (y in top..top+height-1) {
                val currentPair = Pair(x,y)
                val currentVal = fabric.get(currentPair) ?: 0
                if (currentVal == 1) {
                    counter += 1
                }
                fabric.put(currentPair, currentVal + 1)
            }
        }
    }
    
    println(counter)
}

fun partTwo() {
    var fabric = HashMap<Pair<Int,Int>, Int>()
    var overlapped = HashSet<Int>()
    
    for (claim in input) {      
        val left = Regex("""(\d*)(?=,)""").find(claim)?.value!!.toInt()
        val top = Regex("""(\d*)(?=:)""").find(claim)?.value!!.toInt()        
        val width = Regex("""(\d*)(?=x)""").find(claim)?.value!!.toInt()
        val height = Regex("""(\d*)(?=$)""").find(claim)?.value!!.toInt()
        val group = Regex("""(\d*)(?= @)""").find(claim)?.value!!.toInt()
        
        for (x in left..left+width-1) {
            for (y in top..top+height-1) {
                val currentPair = Pair(x,y)
                val currentVal = fabric.get(currentPair) ?: 0
                if (currentVal == 0) {
                    fabric.put(currentPair, group)
                } else {
                    fabric.put(currentPair, -1)
                    overlapped.add(currentVal)
                    overlapped.add(group)
                }
            }
        }
    }
    
    for (claim in input) {      
        val group = Regex("""(\d*)(?= @)""").find(claim)?.value!!.toInt()
        if (!overlapped.contains(group)) {
            println(group)
            return
        }
    }
}
