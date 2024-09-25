package signature

import utils.*
import java.io.File
import java.util.*

class FancyTextDecorator(
    private val name: String,
    private val title: String,
    mediumFontDir: File,
    romanFontDir: File,
) {
    private val mediumFont = mutableMapOf<String, Font>()   // Map of letter to Font
    private val romanFont = mutableMapOf<String, Font>()

    init {
        mediumFont.putAll(initializeFont(mediumFontDir, 4))
        romanFont.putAll(initializeFont(romanFontDir, 11))
    }

    private var decoratedNameLength = calculateLength(name, 10, romanFont)
    private var decoratedTitleLength = calculateLength(title, 5, mediumFont)
    private var lineLength =
        if (decoratedNameLength > decoratedTitleLength ) {
            decoratedNameLength + (BORDER.length * 4) + (SPACE.length * 4)
        } else {
            decoratedTitleLength + (BORDER.length * 4) + (SPACE.length * 4)
        }

    private val midIndex = (lineLength - (if (name.length > title.length) decoratedTitleLength else decoratedNameLength)) / 2


    private fun initializeFont(file: File, steps: Int): MutableMap<String, Font> {
        val font = mutableMapOf<String, Font>()
        val lines = file.readLines()
        var letter: String
        var width: Int
        for (index in 1..lines.lastIndex step steps) {
            lines[index].split(' ').apply {
                letter = first()
                width = last().toInt()
            }
            val values = buildList {
                for (i in index + 1..<index + steps) {
                    add(lines[i])
                }
            }
            font[letter] = Font(width, values)
        }
        return font
    }
    fun decorateText(): String {
        return buildString {
            appendLine(getDecorators())
            for (i in 0..<10) {
                appendLine(decorateNameRow(i))
            }
            for (i in 0..<3) {
                appendLine(getTitleRow(i))
            }
            appendLine(getDecorators())
        }
    }

    private fun decorateNameRow(index: Int): StringBuilder {
        val row = StringBuilder()
        row.append(BORDER.repeat(2))
        val text = buildString {
            name.forEach { c ->
                val str = c.toString()
                append(if (str == SPACE) SPACE.repeat(10) else romanFont[c.toString()]!!.value[index])
            }
        }
        if (name.length > title.length) {
            row.append(TWO_SPACES)
            row.append(text)
            row.append(TWO_SPACES)
        } else {
            row.append(SPACE.repeat(lineLength - 4))
            row.replace(midIndex, midIndex + decoratedNameLength, text)
        }
        row.append(BORDER.repeat(2))
        return row
    }

    private fun getDecorators(): String {
        return BORDER.repeat(lineLength)
    }

    private fun getTitleRow(index: Int): String {
        val text = buildString {
            title.forEach{ c ->
                val str = c.toString()
                append(if (str == SPACE) SPACE.repeat(5) else mediumFont[c.toString()]!!.value[index])
            }
        }
        return buildString {
            append(BORDER.repeat(2))
            if (name.length > title.length) {
                append(SPACE.repeat(lineLength - 4))
                replace(midIndex, midIndex + decoratedTitleLength, text)
            } else {
                append(TWO_SPACES + text + TWO_SPACES)
            }
            append(BORDER.repeat(2))
        }
    }

    private fun calculateLength(vale: String, spaceAmount: Int, font: Map<String, Font>): Int {
        var length = 0
        vale.forEach {
            length += when (it) {
                ' ' -> spaceAmount
                else -> font[it.toString()]!!.length
            }
        }
        return length
    }
}


fun main() {
    val sc = Scanner(System.`in`)

    val fullName = getInput(sc, "Enter name and surname")
    val title = getInput(sc, "Enter person's status").uppercase()

    val mediumFont = File("src/font/medium.txt")
    val romanFont = File("src/font/roman.txt")

    println(FancyTextDecorator(fullName, title, mediumFont, romanFont).decorateText())
    sc.close()
}