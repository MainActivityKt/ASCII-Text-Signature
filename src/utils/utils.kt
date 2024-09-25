package utils

import java.util.*

fun getInput(sc: Scanner, message: String): String {
    print("$message: ")
    return sc.nextLine()
}

const val TWO_SPACES = "  "
const val BORDER = "8"
const val SPACE = " "
const val MID_SPACE_SIZE = 6