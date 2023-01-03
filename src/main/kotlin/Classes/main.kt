package Classes

fun main (args: Array<String>){
    // buildAquarium()

    // val curry = SimpleSpice()
    // println(curry.spiceLevel)
    // println(curry.heat)


    val spices = listOf(
        Spice("curry"),
        Spice("pepper", "hot"),
        Spice("cayenne", "soft"),
        Spice("ginger"),
        Spice("red curry", "soft"),
        Spice("red pepper", "hot")
    )

    val hotSpices = spices.filter { it.heat == 3 }
    val mildSpices = spices.filter { it.heat == 5 }
    val softSpices = spices.filter { it.heat == 1 }

    // println("Hot spices: ")
    // hotSpices.printEverything()
    // println("Mild spices: ")
    // mildSpices.printEverything()
    // println("Soft spices: ")
    // softSpices.printEverything()
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    println(
        "width: ${myAquarium.width}" +
        " height: ${myAquarium.height}" +
        " length: ${myAquarium.length}"
    )

    myAquarium.height = 80

    println("Aquarium new height: ${myAquarium.height}")
    println("Aquarium volume: ${myAquarium.volume}")

}
