package Classes

class SimpleSpice {
    var spiceName = "Curry"
    var spiceLevel = "Mild"
    var heat: Int = 0
        get() = when(spiceLevel){
            "Soft" -> 1
            "Mild" -> 5
            "Hot" -> 3
            else -> 0
         }
}