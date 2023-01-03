package Classes.Spices

fun main(args: Array<String>){
     val curry = Curry("curry", "hot")
     println("Curry color: ${curry.color}")
     curry.grind()
     curry.prepareSpice()

    val spiceContainer = SpiceContainer("Curry")
    println(spiceContainer)
    println(spiceContainer.label)

    println(YellowColor.color.rgb)
}

sealed class Spice(var name: String, var spiciness: String = "mild") : SpiceColor by YellowColor {

    val heat: Int
        get() = when(spiciness){
            "soft" -> 1
            "mild" -> 5
            "hot" -> 3
            else -> 0
        }

    init {
        println("Name: $name Spiciness: $spiciness Heat: $heat")
    }

    fun makeSalt(){
        TODO("Make the spice salty")
    }

    abstract fun prepareSpice()
}

class Curry(name: String = "curry", spiciness: String) : Spice(name, spiciness), Grinder {
    override fun prepareSpice() {
        println("Preparing spice: $name")
    }
}

interface Grinder {
    fun grind() {
        println("Going to grind ${this@Grinder}")
    }
}

interface SpiceColor {
    val color: Color
}

object YellowColor : SpiceColor {
    override val color = Color.YELLOW
}

data class SpiceContainer(val name: String) {
    val label = when(name){
        "Curry" -> "curryLabel"
        else -> "notCurrylabel"
    }
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);
}