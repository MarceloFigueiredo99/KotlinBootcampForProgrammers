package Classes

open class Aquarium {
    open var width: Int = 20
    var height: Int = 40
    var length: Int = 100

    var volume: Int
        get() = width.times(height).times(length) / 1000
        set(value) {height = (value * 1000) / (width * length)}

    open fun method(){

    }
}

class Tank: Aquarium(){
    override var width = 10

    override fun method(){

    }
}