import java.io.File

val length =  5

fun main() {
    val inputFileName = "kelimeler.txt"
    val outputFileName = "BesHarfliKelimeler.txt"
    readFileFilterAndWriteLines(inputFileName, outputFileName)
}

fun readFileFilterAndWriteLines(inputFileName: String, outputFileName: String) {
    try {
        val inputFile = File(inputFileName)
        val outputFile = File(outputFileName)

        if (inputFile.exists()) {
            val filteredLines = inputFile.readLines()
                .map { it.lowercase() }
                .filter { it.length == length && !it.containsSpecialCharsOrSpaces() }
            
            outputFile.printWriter().use { out ->
                filteredLines.forEach { line ->
                    out.println(line)
                }
            }

            println("Filtered lines have been written to $outputFileName")
        } else {
            println("File not found.")
        }
    } catch (e: Exception) {
        println("An error occurred while processing the file: ${e.message}")
    }
}

fun String.containsSpecialCharsOrSpaces(): Boolean {
    val specialChars = listOf('î', 'â', 'û', ' ')
    return this.any { it in specialChars }
}
