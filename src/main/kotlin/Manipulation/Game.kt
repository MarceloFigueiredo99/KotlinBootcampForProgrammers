package Manipulation

import Fundamentals.CONSTANTS
import java.util.*

class Game {
    var path = mutableListOf(Directions.START)
    var map = Location()

    // North
    val north = { path.add(Directions.NORTH) }

    // SOUTH
    val south = { path.add(Directions.SOUTH) }

    // EAST
    val east = { path.add(Directions.EAST) }

    // WEST
    val west = { path.add(Directions.WEST) }

    // END
    val end: () -> (Boolean) = {
        path.add(Directions.END)
        println("Game Over:")
        println(path)
        path.clear()
        false
    }

    fun move(where: () -> Unit) {
        where()
    }

    fun makeMove(command: String?) {
        if (command.equals("n"))  { north(); map.updateLocation(Directions.NORTH) }
        else if (command.equals("s")) { south(); map.updateLocation(Directions.SOUTH) }
        else if (command.equals("e")) { east(); map.updateLocation(Directions.EAST) }
        else if (command.equals("w")) { west(); map.updateLocation(Directions.WEST) }
        else end()
    }
}

fun List<Int>.divisibleBy3(block: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}

fun main(args: Array<String>) {
    val game = Game()

    println(game.path)

    game.north()
    game.south()
    game.east()
    game.west()
    game.end()

    println(game.path)

    val numbers = listOf(1,2,3,4,5,6,7,8,9,0)

    // rem = resto da divisao pelo argumento, neste caso é o resto da divisão do it por 3
    println(numbers.divisibleBy3 { it.rem(3) })

    val game2 = Game()

    while (true){
        print("Enter a direction: n/s/e/w:")
        game2.makeMove(readlnOrNull())
        println(game.map.getDescription())
    }
}
