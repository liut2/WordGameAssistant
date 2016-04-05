# WordGameAssistant
## WordGameAssistant's command-line syntax
>$ java WordGameAssistant [--dictionary=path-to-dictionary-file] action letters


The legal values for action are: words, use-all-letters, allow-repetition, and regex. These actions correspond to the four WordGameAssistant methods wordsUsingOnlyLetters, wordsUsingAllLetters, wordsUsingLettersAllowingRepetition, and wordsMatchingRegularExpression, respectively. 

In each case, the program should print to standard output (i.e. System.out) a list of words, one per line, ordered from longest word to shortest (and ordered alphabetically for same-length words--see the comment on wordListOrderedBySize).

The optional --dictionary flag allows you to explicitly specify your dictionary file. If the --dictionary option is not included, WordGameAssistant should (try to) use a dictionary file named "dictionary.txt" in the current working directory (which will typically be the same directory as the WordGameAssistant.class file when you execute the "java WordGameAssistant ..." command).

## Usage examples
In each of these cases, I'm assuming that dictionary.txt file is the this one referenced in phase 2. Also, the $ at the beginning of each example represents your command-line program's prompt. You don't type it.
* The "words" action. (Note in this example that my demo dictionary does not include any single-letter words.)
    
    >$ java WordGameAssistant words cra<br>
    
    arc<br>
    car<br>
    ar<br>
* The "use-all-letters" action.
    
    >$ java WordGameAssistant use-all-letters cra<br>
    
    arc<br>
    car<br>
* The "allow-repetition" action. (No idea the meanings of oot, otto, and oo, but they're in the file.)
    
    >$ java WordGameAssistant allow-repetition ot<br>
    
    otto<br>
    toot<br>
    oot<br>
    too<br>
    tot<br>
    oo<br>
    to<br>
* The "regex" action. Note that on a Unix command line, *, ^, and $ are special characters, so to send them to the WordGameAssistant program, we need to put them inside single quotes '...'. You would not include the quotes if providing command-line arguments via IntelliJ.
    
    >$ java WordGameAssistant regex '^st.*nch$'<br>
    
    staunch<br>
    stanch<br>
    stench<br>
