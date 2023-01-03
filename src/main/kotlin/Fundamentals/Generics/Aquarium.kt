package Fundamentals.Generics

open class WaterSupply(var needsProcessed: Boolean)

class TapWater: WaterSupply(true){
    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater: WaterSupply(false)

class LakeWater: WaterSupply (true) {
    fun filter() {
        needsProcessed = false
    }
}

class Aquarium<T: WaterSupply> (val watterSupply: T) {
    fun addWater() {
        // Check function checks the state of the class,
        // acts as an assertion and will throw an exception if
        // The condition is false, otherwise execute the following code
        check(!watterSupply.needsProcessed) {
            "water supply needs processed"
        }
        println("adding water from $watterSupply")
    }
}

fun genericExample(){
    val aquarium = Aquarium(TapWater())
    aquarium.watterSupply.addChemicalCleaners()

    // Will give error, becaus with :WaterSupply,
    // Aquarium does not accept any other variable type that is not WaterSupply
    // val aquarium2 = Aquarium("String")
    // println(aquarium2.watterSupply)

    // Will give error, becaus with :Any, Aquarium does not accept null
    // val aquarium3 = Aquarium(null)
    // println(aquarium3.watterSupply)

    val  dirtyAquarium = Aquarium(LakeWater())
    dirtyAquarium.watterSupply.filter()
    dirtyAquarium.addWater()
}

class Building <out T: BaseBuildingMaterial>(private val baseBuildingMaterial: T){
    val baseMaterialsNeeded = 100

    val actualMaterialsNeeded = baseMaterialsNeeded + baseBuildingMaterial.numberNeeded

    fun build() {
        println("This building needs $actualMaterialsNeeded ${baseBuildingMaterial::class.simpleName} to be built")
    }
}

open class BaseBuildingMaterial(val numberNeeded: Int = 1)

class Wood: BaseBuildingMaterial(4)

class Brick: BaseBuildingMaterial(8)

fun <T: BaseBuildingMaterial> isSmallBuilding(building: Building<T>){
    building.build()

    if(building.actualMaterialsNeeded < 500) {
        println("small building")
    }
    else {
        println("large building")
    }
}

fun main(args: Array<String>){
    // genericExample()
    val building = Building(Wood())
    isSmallBuilding(building)
}