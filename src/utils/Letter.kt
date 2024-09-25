package utils


enum class Letter(val structure: Array<String>) {
    //Represents a letter as a List of strings (top, middle, bottom)
    A(arrayOf("____", "|__|", "|  |")),
    B(arrayOf("___ ", "|__]", "|__]")),
    C(arrayOf("____", "|   ", "|___")),
    D(arrayOf("___ ", "|  \\", "|__/")),
    E(arrayOf("____", "|___", "|___")),
    F(arrayOf("____", "|___", "|   ")),
    G(arrayOf("____", "| __", "|__]")),
    H(arrayOf("_  _", "|__|", "|  |")),
    I(arrayOf("_", "|", "|")),
    J(arrayOf(" _", " |", "_|")),
    K(arrayOf("_  _", "|_/ ", "| \\_")),
    L(arrayOf("_   ", "|   ", "|___")),
    M(arrayOf("_  _", "|\\/|", "|  |")),
    N(arrayOf("_  _", "|\\ |", "| \\|")),
    O(arrayOf("____", "|  |", "|__|")),
    P(arrayOf("___ ", "|__]", "|   ")),
    Q(arrayOf("____", "|  |", "|_\\|")),
    R(arrayOf("____", "|__/", "|  \\")),
    S(arrayOf("____", "[__ ", "___]")),
    T(arrayOf("___", " | ", " | ")),
    U(arrayOf("_  _", "|  |", "|__|")),
    V(arrayOf("_  _", "|  |", " \\/ ")),
    W(arrayOf("_ _ _", "| | |", "|_|_|")),
    X(arrayOf("_  _", " \\/ ", "_/\\_")),
    Y(arrayOf("_   _", " \\_/ ", "  |  ")),
    Z(arrayOf("___ ", "  / ", " /__")),
    SPACE(arrayOf("      ", "      ", "      "));
}
