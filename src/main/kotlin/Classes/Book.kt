package Classes

open class Book(var title: String = "Book1", var author: String = "Author1"){
    private var currentPage = 1

    open fun readPage() {
        currentPage++
        println("Reading a page from $title written by $author\n Current page: $currentPage")
    }
}

class Ebook(var format: String = "text"): Book() {
    private var currentWords = 0

    override fun readPage() {
        currentWords += 250
        println("Reading a page from $title written by $author\n Current words: $currentWords")
    }
}

interface interf {
    var a: Int

    fun method(){
        a *= 2
    }
}