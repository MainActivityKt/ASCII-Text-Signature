package utils

data class Font(val length: Int, val structure: List<String>)
/** Representing the font type
length represents the amount of characters a specific letter's font takes, horizontally
structure is a list, containing the value of each parts of the font. For smaller fonts (medium), it has the string values
for top, middle, and bottom parts of the font string
 */