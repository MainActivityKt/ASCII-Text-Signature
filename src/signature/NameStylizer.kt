package signature

import utils.ASTERISK
import utils.SPACE
import java.util.Scanner

fun stylizeName(name: String): String {
    val stars = "*".repeat(name.length + 4)
    // the length of the text is the name length + 4 (two stars and two spaces)
    return buildString {
        appendLine(stars)
        appendLine(ASTERISK + SPACE + name + SPACE + ASTERISK)
        appendLine(stars)
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val name = sc.nextLine()
    println(stylizeName(name))
    sc.close()
}