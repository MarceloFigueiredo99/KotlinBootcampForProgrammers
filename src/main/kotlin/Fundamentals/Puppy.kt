package Fundamentals

import java.lang.Exception
import java.util.*

class Puppy {
    fun playWithBook(book: Book){
        while (book.pages > 1){
            val randomPagesTorned = Random().nextInt(1, book.pages)
            println("Puppy going to torn $randomPagesTorned pages")
            book.tornPages(randomPagesTorned)
            println("Number of pages: ${book.pages}")
            println("Weight: ${book.calculateWeight()}")
        }
        println("Puppy destroyed the whole book. No pages left to tear up")
    }
}