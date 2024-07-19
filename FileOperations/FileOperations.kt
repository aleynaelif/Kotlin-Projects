import java.io.File

fun main() {
    val fileName = "kelimeler.txt" // Replace with your file name
    readFile(fileName)
}

fun readFile(fileName: String) {
    try {
        val file = File(fileName)
        if (file.exists()) {
            file.forEachLine { line ->
                println(line)
            }
        } else {
            println("File not found.")
        }
    } catch (e: Exception) {
        println("An error occurred while reading the file: ${e.message}")
    }
}
