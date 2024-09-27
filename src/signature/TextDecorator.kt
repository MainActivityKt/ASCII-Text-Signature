package signature

import utils.*
import java.util.Scanner

enum class Row {
    TOP, MIDDLE, BOTTOM
}
class TextDecorator(private val name: String, private val title: String) {
    private val firstName = name.split(' ').first()
    private val lastName = name.split(' ').last()

    private var decoratedNameLength: Int = 0
    private var lineLength = calculateLength()
    private val midIndex =
        (lineLength - (if (name.length > title.length) title.length else decoratedNameLength)) / 2

    fun decorateText(): String {
        return buildString {
            appendLine(getDecorators())
            appendLine(decorateRow(Row.TOP))
            appendLine(decorateRow(Row.MIDDLE))
            appendLine(decorateRow(Row.BOTTOM))
            appendLine(getTitleRow())
            appendLine(getDecorators())
        }
    }

    private fun decorateRow(row: Row): StringBuilder {
        val str = StringBuilder()
        str.append(ASTERISK)
        val text = StringBuilder().apply {
            firstName.forEachIndexed { index, c ->
                append(getLetter(c, row))
                if (index != firstName.lastIndex) {
                    append(SPACE)
                }
            }
            append(" ".repeat(MID_SPACE_SIZE))
            lastName.forEachIndexed { index, c ->
                append(getLetter(c, row))
                if (index != lastName.lastIndex) {
                    append(SPACE)
                }
            }
        }
        if (name.length > title.length) {
            str.append(TWO_SPACES)
            str.append(text)
            str.append(TWO_SPACES)
        } else {
            str.append(SPACE.repeat(lineLength - 2))
            str.replace(midIndex, midIndex + decoratedNameLength, text.toString())
        }
        str.append(ASTERISK)
        return str
    }

    private fun getLetter(char: Char, row: Row): String {
        return Letter.valueOf(char.toString()).structure.get(
            when (row) {
                Row.TOP -> 0
                Row.MIDDLE -> 1
                Row.BOTTOM -> 2
            }
        )
    }

    private fun getDecorators(): String {
        return ASTERISK.repeat(lineLength)
    }

    private fun getTitleRow(): StringBuilder {
        return StringBuilder().apply {
            append(ASTERISK)
            if (name.length > title.length) {
                append(SPACE.repeat(lineLength - 2))
                replace(midIndex, midIndex + title.length, title)
            } else {
                append(TWO_SPACES + title + TWO_SPACES)
            }
            append(ASTERISK)
        }
    }

    private fun calculateLength(): Int {
        name.forEach {
            decoratedNameLength += when (it) {
                'I' -> 1
                'J' -> 2
                'T' -> 3
                'W', 'Y' -> 5
                ' ' -> 6
                else -> 4
            }
        }
        val spaces = firstName.length - 1 + lastName.length - 1
        decoratedNameLength += spaces

        return (if (name.length > title.length) decoratedNameLength else title.length) +
                (TWO_SPACES.length * 2) + (ASTERISK.length * 2)
    }
}

fun main() {
    val sc = Scanner(System.`in`)

    val fullName = getInput(sc, "Enter name and surname").uppercase()
    val title = getInput(sc, "Enter person's status")

    println(TextDecorator(fullName, title).decorateText())
    sc.close()
}