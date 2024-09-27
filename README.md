# ASCII Text Signature


Working with string and texts and printing them to the console
is one of the everyday tasks of a programmer.
But, the text isn't pretty enough to be pleasing to the eyes. 

What if we try to add a little “make-up”,get very creative with fonts, draw
awesome letters with other letters? That's what this project is about.

## Stage 1/4: Primitive Art

In this stage, a simple tag for someone with the first name "Hyper" and the last name "Skill" is generated, with a frame
around the text. 

Stage implementation: [SimpleText.kt](src/signature/SimpleText.kt)

**Example:** 

     _____________
    | Hyper Skill |
    •••••••••••••


## Stage 2/4: Star quality

The program first reads a text from the input, containing a firstname and a lastname. 
Then, it prints out the name with asterisk borders tag, with the padding of one space to the left and right of the name.

Stage implementation: [NameStylizer.kt](src/signature/NameStylizer.kt)

**Example 1:**

When the user inputs Albert Einstein:

    *******************
    * Albert Einstein *
    *******************

**Example 2:**

When the user inputs Nikola Tesla:

    ****************
    * Nikola Tesla *
    ****************

# Stage 3/4: Make it notable

The new font will be larger and will consist of multiple rows and columns of standard console symbols, as follows:

    ____ ___  ____ ___  ____ ____ ____ _  _ _  _ _  _ _    _  _
    |__| |__] |    |  \ |___ |___ | __ |__| |  | |_/  |    |\/|
    |  | |__] |___ |__/ |___ |    |__] |  | | _| | \_ |___ |  |
    _  _ ____ ___  ____ ____ ____ ___ _  _ _  _ _ _ _ _  _ _   _ ___ 
    |\ | |  | |__] |  | |__/ [__   |  |  | |  | | | |  \/   \_/    /
    | \| |__| |    |_\| |  \ ___]  |  |__|  \/  |_|_| _/\_   |    /__

In this stage: 
 
- The user is prompted to input a full name, and a title.
- The program will generate a tag for both of the values, the name tag contains asterisks like the previous stage.
- The name is printed out using the new fany font, while the title is printed out as is.
- If the name is lengthier than the title, it'll be centered. If not, the title will be centered. The short one will be printed with two padding spaces to their left and right.
- The center index is calculated as follows:

`  midIndex = (lineLength - (if (name.length > title.length) title.length else decoratedNameLength)) / 2`
Line Length is calculated by adding the space each fancy letter in the name takes, plus additional border and paddings length.

Stage implementation: [TextDecorator.kt](src/signature/TextDecorator.kt)

**Example 1:**

    Enter name and surname: John S
    Enter person's status: Worker-coworker-superdupercoworker
    ****************************************
    *      _ ____ _  _ _  _      ____      *
    *      | |  | |__| |\ |      [__       *
    *     _| |__| |  | | \|      ___]      *
    *  Worker-coworker-superdupercoworker  *
    ****************************************

**Example 2:**

    Enter name and surname: Mr Anonimous
    Enter person's status: Participant
    **************************************************************
    *  _  _ ____      ____ _  _ ____ _  _ _ _  _ ____ _  _ ____  *
    *  |\/| |__/      |__| |\ | |  | |\ | | |\/| |  | |  | [__   *
    *  |  | |  \      |  | | \| |__| | \| | |  | |__| |__| ___]  *
    *                        Participant                         *
    **************************************************************

## Stage 4/4: ASCII New Roman

In this final stage:
- Our program now uses two fonts, medium and roman. The medium font is the same fancy
font used in the previous stage, but they both are provided in a text file instead.
- The program first prompts the user to input a name and a title, like before.
- Then, it reads and initializes the fonts in a letter-font map, in which the letter 
is the key for that letter's font, and the font type stores the values and length of that font, taken from its text fie.
- The name is printed out with roman font, while the title uses the medium font. The centered text is determined using the same strategy as stage 3.
- Borders are now replaced with `88` values.

Stage implementation: [FancyTextDecorator.kt](src/signature/FancyTextDecorator.kt)

**Example 1:**

    Enter name and surname: Ian One
    Enter person's status: VIP
    888888888888888888888888888888888888888888888888888888888888888888888888888888888
    88  ooooo                                   .oooooo.                           88
    88  `888'                                  d8P'  `Y8b                          88
    88   888   .oooo.   ooo. .oo.             888      888 ooo. .oo.    .ooooo.    88
    88   888  `P  )88b  `888P"Y88b            888      888 `888P"Y88b  d88' `88b   88
    88   888   .oP"888   888   888            888      888  888   888  888ooo888   88
    88   888  d8(  888   888   888            `88b    d88'  888   888  888    .o   88
    88  o888o `Y888""8o o888o o888o            `Y8bood8P'  o888o o888o `Y8bod8P'   88
    88                                                                             88
    88                                                                             88
    88                                                                             88
    88                                _  _ _ ___                                   88
    88                                |  | | |__]                                  88
    88                                 \/  | |                                     88
    888888888888888888888888888888888888888888888888888888888888888888888888888888888

**Example 2:**

    Enter name and surname: A b
    Enter person's status: long participant
    88888888888888888888888888888888888888888888888888888888888888888888888888888888
    88                         .o.                  .o8                           88
    88                        .888.                "888                           88
    88                       .8"888.                888oooo.                      88
    88                      .8' `888.               d88' `88b                     88
    88                     .88ooo8888.              888   888                     88
    88                    .8'     `888.             888   888                     88
    88                   o88o     o8888o            `Y8bod8P'                     88
    88                                                                            88
    88                                                                            88
    88                                                                            88
    88  _    ____ _  _ ____      ___  ____ ____ ___ _ ____ _ ___  ____ _  _ ___   88
    88  |    |  | |\ | | __      |__] |__| |__/  |  | |    | |__] |__| |\ |  |    88
    88  |___ |__| | \| |__]      |    |  | |  \  |  | |___ | |    |  | | \|  |    88
    88888888888888888888888888888888888888888888888888888888888888888888888888888888

