package Fundamentals

fun main(args: Array<String>) {
    val book = Book("title1", "author1", 1)

    println("Pair: ${book.titleAuthorPair()}")

    val triple = book.titleAuthorYearTriple()
    println("Triple: $triple")

    println("Here is the book ${triple.first}, written by ${triple.second} in the year of ${triple.third}")

    val allBooks = setOf("Hamlet", "Romeo and Juliet", "Dream of a Summer Night")

    val library = mapOf(allBooks to "William Shakespeare")

    println(library.any {
        it.key.contains("Hamlet")
    })

    val moreBooks = mutableMapOf("Book1" to "Author1", "Book2" to "Author2")
    println("More books: $moreBooks")

    moreBooks.getOrElse("Book3") { moreBooks.put("Book3", "Author3") }
    println("More books: $moreBooks")

    println(book.canBorrow())
    println(book.canBorrow())
    println(book.canBorrow())
    println(book.canBorrow())
    println(book.canBorrow())

    book.printUrl()

    val puppy = Puppy()

    val book2 = Book("Book2", "Author2", 10)

    println("Number of initial pages: ${book2.pages}")
    println("Initial weight: ${book2.calculateWeight()}")

    puppy.playWithBook(book2)

}
