package Classes

class Spice (var name: String, var spiciness: String = "mild") {

    val heat: Int
        get() = when(spiciness){
            "soft" -> 1
            "mild" -> 5
            "hot" -> 3
            else -> 0
        }

    init {
        //println("Name: $name Spiciness: $spiciness Heat: $heat")
    }

    fun makeSalt(){
        TODO("Make the spice salty")
    }
}

fun List<Spice>.printEverything(){
    for (i in 0 .. this.size - 1){
        print("Name: ${this[i].name}")
        print(" Spiciness: ${this[i].spiciness}")
        print(" Heat: ${this[i].heat} \n")
    }
}
