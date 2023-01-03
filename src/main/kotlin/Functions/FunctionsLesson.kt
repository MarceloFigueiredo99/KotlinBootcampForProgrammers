package Functions

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.*

fun dayOfWeek(){
    val dayOfWeek = when(getInstance().get(DAY_OF_WEEK)){
        SUNDAY -> "Sunday"
        MONDAY -> "MONDAY"
        TUESDAY -> "TUESDAY"
        WEDNESDAY -> "WEDNESDAY"
        THURSDAY -> "THURSDAY"
        FRIDAY -> "FRIDAY"
        SATURDAY -> "SATURDAY"
        else -> {
        }
    }
    println("What day is it today? $dayOfWeek")
}

fun verifyTime1(args: Array<String>) {
    when(args[0].toInt()){
        in 0 .. 11 -> println("Good morning, Kotlin")
        in 12 .. 23 -> println("Good night, Kotlin")
        else -> println("Invalid hour")
    }
}

fun verifyTime2(args: Array<String>) {
    println(if (args[0].toInt() in 0 .. 11) "Good morning" else ( if (args[0].toInt() in 12 .. 23) "Good night" else "Good nothing. the hour is invalid"))
}

fun feedTheFish(){
    val day = randomDay()
    val food = fishFood(day)

    println("Today is $day and the fish eat $food")
}

fun randomDay(): String {
    val weekDays = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Monday")
    return weekDays[Random().nextInt(7)]
}

fun randomFood(): String {
    val food = listOf("pellets", "flakes", "sticks", "wafers", "chips", "tablets", "dried")
    return food[Random().nextInt(7)]
}

fun getFortuneCookie(): String {
    val fortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )
    print("Enter your birthday:")

    var birthday = readlnOrNull()?.toIntOrNull() ?: 1

    var fortuneIndex = birthday % fortunes.size

    return fortunes[fortuneIndex]
}

fun String.isValidDate(): Boolean {
    val dateFormat = SimpleDateFormat("dd-MM-yyyy")

    return try {
        dateFormat.parse(this)
        true
    } catch (e: Exception){
        false
    }
}

fun getTakeItEasy(): String {
    val fortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )
    print("Enter your birthday:")

    var birthday = readlnOrNull()?.toIntOrNull() ?: 1

    var fortuneIndex = 0

    var i = 0

    repeat(10){
        fortuneIndex = birthday % fortunes.size
        if(fortunes[fortuneIndex] == "Take it easy and enjoy life!"){
            return fortunes[fortuneIndex]
        }
        i++
    }

    /*while (fortuneIndex != 6 && i < 10){
        fortuneIndex = birthday % fortunes.size
        i++
    }*/

    println("Executed the code $i times")

    return "Take it easy fortune was not found"
}

fun fishFood(day: String): String {
    val food = listOf("pellets", "flakes", "sticks", "wafers", "chips", "tablets", "dried")
    return when (day){
        "Monday" -> food[0]
        "Tuesday" -> food[1]
        "Wednesday" -> food[2]
        "Thursday" -> food[3]
        "Friday" -> food[4]
        "Saturday" -> food[5]
        "Sunday" -> food[6]
        else -> "fasting"
    }
}

fun getBirthday(): Int{
    print("Enter your birthday:")
    return readlnOrNull()?.toIntOrNull() ?: 1
}

fun getFortuneCookie2(): String {
    val fortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )

    var birthday = getBirthday()

    return when(birthday){
        in 0..10 -> "Fortunately you were born before 11"
        in 11..14 -> "Birthday pary going to be on day $birthday"
        in 15 .. 30 -> "Born in the last 2 weeks of the month"
        else -> fortunes[birthday % fortunes.size]
    }
}

fun callGetFortune() {
    var fortune: String
    for (i in 1..10) {
        fortune = getFortune(getBirthday())
        println("\nYour fortune is: $fortune")
        if (fortune.contains("Take it easy")) break;
    }
}

fun getFortune(birthday: Int): String {
    val fortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",// 40
        "Treasure your friends because they are your greatest fortune."
    )

    return when(birthday){
        in 0..10 -> "Fortunately you were born before 11"
        in 11..14 -> "Birthday pary going to be on day $birthday"
        in 15 .. 30 -> "Born in the last 2 weeks of the month"
        else -> fortunes[birthday % fortunes.size]
    }
}

fun canAddFish(
    tankSize: Double,
    currentFish: List<Int>,
    fishSize: Int = 2,
    hasDecorations: Boolean = true
): Boolean {
    val totalFishDim: Double
    val numberOfFishInTheTank = currentFish.sum().plus(fishSize)

    return if (hasDecorations){
        totalFishDim = 0.8.times(tankSize)

        numberOfFishInTheTank <= totalFishDim
    } else {
        totalFishDim = 1.0.times(tankSize)

        numberOfFishInTheTank <= totalFishDim
    }

    // println(FunctionsTraining.canAddFish(10.0, listOf(3,3,3)))
    // println(FunctionsTraining.canAddFish(8.0, listOf(2,2,2), hasDecorations = false))
    // println(FunctionsTraining.canAddFish(9.0, listOf(1,1,3), 3))
    // println(FunctionsTraining.canAddFish(10.0, listOf(), 7, true))
}
fun whatShouldIDoTodayMain(){
    println(
        whatShouldIDoToday(
            mood = "happy"
        )
    )

    println(
        whatShouldIDoToday(
            mood = "unamused",
            weather = "cloudy",
            temperature = 10
        )
    )

    println(
        whatShouldIDoToday(
            mood = "sad",
            temperature = 30
        )
    )

    println(
        whatShouldIDoToday(
            mood = "sad"
        )
    )

    println(
        whatShouldIDoToday(
            mood = "sad",
            weather = "rainy",
            temperature = 0
        )
    )

    println(
        whatShouldIDoToday(
            mood = "angry",
            temperature = 36
        )
    )

    println("How is your mood today?")
    val mood = readLine()
    println(whatShouldIDoToday(mood!!))
}

fun whatShouldIDoToday(
    mood: String,
    weather: String = "sunny",
    temperature: Int = 24
) : String =
    when {
        stayInBed(mood, weather, temperature) -> "stay in bed"
        goForWalk(mood, weather) -> "go for a walk"
        netflix(weather, temperature) -> "FunctionsTraining.netflix"
        goForIceCream(temperature, mood) -> "go for a ice cream"
        swimming(temperature) -> "go FunctionsTraining.swimming"
        else -> "Stay at home and read"
    }

fun stayInBed(mood: String, weather: String, temperature: Int) = (mood == "sad" && weather == "rainy" && temperature == 0)

fun goForWalk(mood: String, weather: String) = (mood == "happy" && weather == "sunny")

fun netflix(weather: String, temperature: Int) = (weather == "cloudy" && temperature < 15)

fun goForIceCream(temperature: Int, mood: String) = (temperature > 24 && mood == "sad")

fun swimming(temperature: Int) = temperature > 35

fun filtering(){
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )

    println("Long name curries: ${spices.filter { it.length > 6 }}")

    println("Curries that start with 'c' and end with 'e': ${spices.filter { it[0] == 'c' && it[it.lastIndex] == 'e' }}")

    fun checksConditions(curry: String) = curry[0] == 'c' && curry[curry.lastIndex] == 'e'
    println("Curries that start with 'c' and end with 'e': ${spices.filter { checksConditions(it) }}")

    println("The elements that start with the letter 'c' and are on the first 3 elements of the list: ${spices.filterIndexed { index, s -> index < 3 }.filter { it[0] == 'c' }}")
}

fun lambda1() {
    val rollDice = { sides:Int -> println("Number of faces: $sides"); if(sides ==0) {0} else {Random().nextInt(1, 12)} }

    rollDice(4)
}

fun lambdaFunctionTypes() {
    val rollDice2: (Int) -> Int = { sides -> println("Number of faces: $sides"); if(sides == 0) {0} else {Random().nextInt(1, 12)}}
}

fun lambdaFunctionAsArgument(){

    val rollDice2: (Int) -> Int = { sides -> println("Number of faces: $sides"); if(sides == 0) {0} else {
        Random().nextInt(1, 12)}}

    fun gamePlay(operation: Int) {
        println("Operation = $operation")
    }


    gamePlay(rollDice2(4))
}




