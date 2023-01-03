package Fundamentals

class Book (var title: String, var author: String, var year: Int) {
    val url = BASE_URL
    var numberOfBorrowed = 0
    var pages = numberOfPages

    fun titleAuthorPair (): Pair<String, String> {
        return Pair(title, author)
    }

    fun titleAuthorYearTriple (): Triple<String, String, Int> {
        return Triple(title, author, year)
    }

    fun canBorrow(): Boolean {
        numberOfBorrowed++
        return CONSTANTS.maxNumberOfBooks >= numberOfBorrowed
    }

    fun printUrl() {
        println("Book $title url is: $url/$title.html")
    }

    companion object {
        const val BASE_URL = "internet.com"
        const val numberOfPages = 150
    }
}

fun Book.calculateWeight(): Double = pages * 1.5

fun Book.tornPages(numberOfTornPages: Int){
    pages -= numberOfTornPages
}