import java.io.File
import kotlin.random.Random

val fileName = "BesHarfliKelimeler.txt"


fun main (){
    println(getRandomWordFromFile(fileName))
}


fun getRandomWordFromFile(filePath: String): String {
    // Read all lines into a list
    val words = File(filePath).readLines()
    
    // Check if the file is not empty
    if (words.isEmpty()) {
        throw IllegalArgumentException("The file is empty")
    }
    
    // Generate a random index
    val randomIndex = Random.nextInt(words.size)
    
    // Return the word at the random index
    return words[randomIndex]
}