package signature

import utils.Symbol
import java.util.Scanner

fun stylizeName(name: String): String {
    val stars = "*".repeat(name.length + 4)
    return buildString {
        appendLine(stars)
        appendLine(Symbol.STAR.value + Symbol.SPACE.value + name + Symbol.SPACE.value + Symbol.STAR.value)
        appendLine(stars)
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val name = sc.nextLine()
    println(stylizeName(name))
}