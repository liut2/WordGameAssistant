// author : Xi Chen
package edu.carleton.chenx2;

/**
 * WordGameAssistant
 * Public interfaces documented by Jeff Ondich, 30 March 2016.
 *
 * The main support class for the WordGameAssistant project in
 * CS 257, Spring 2016, Carleton College. An object of this class
 * will encapsulate a dictionary (i.e. a list of strings considered
 * to be legal words for the word game in question), and provides
 * methods for accessing the dictionary in a variety of ways.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordGameAssistant {

    /**
     * Initializes this WordGameAssistant given a word list contained in
     * the specified file. The file must consist of one word per line.
     *
     * @param dictionaryFilePath the path to the dictionary file
     */
    public WordGameAssistant(String dictionaryFilePath) {
        // Not yet implemented.
    }

    /**
     * Initializes this WordGameAssistant given the specified list of words.
     *
     * @param wordList the words
     */
    public WordGameAssistant(String[] wordList) {
        // Not yet implemented.
    }

    /**
     * This method takes a string of available letters, and generates a list of
     * all the legal words that can be formed from only the specified letters, without
     * repetition. For example, if we're using a normal English legal word list
     * and letters="woew", the resulting list will contain "wow", "woe", "owe",
     * and "we" (and maybe "wo" and "ew" if we're using a Scrabble-like dictionary
     * containing those words).
     *
     * Matches are case-insensitive. The list of words generated is not guaranteed
     * to be in any particular order.
     *
     * @param letters the list of available letters
     * @return the list of matching words
     */
    public List<String> wordsUsingOnlyLetters(String letters) {
        // Not yet implemented.
        return Arrays.asList("dog", "cat", "moose");
    }

    /**
     * This method takes a string of available letters, and generates a list of
     * all the legal words that can be formed from only the specified letters, but allowing
     * letter repetition. For example, if we're using a normal English legal word list
     * and letters="oew", the resulting list will contain "wow", "woe", "owe", "wee",
     * "ewe", "woo", and "we" (and maybe "wo" and "ew" if we're using a Scrabble-like
     * dictionary containing those words).
     *
     * Matches are case-insensitive. The list of words generated is not guaranteed
     * to be in any particular order.
     *
     * @param letters the list of available letters
     * @return the list of matching words
     */
    public List<String> wordsUsingLettersAllowingRepetition(String letters) {
        // Not yet implemented.
        return new ArrayList<String>();
    }

    /**
     * This method takes a string of available letters, and generates a list of
     * all the legal words that can be formed using exactly the specified letters, without
     * repetition or omission. For example, if we're using a normal English legal word list
     * and letters="ecra", the resulting list will contain "race", "care", and "acre".
     *
     * Matches are case-insensitive. The list of words generated is not guaranteed
     * to be in any particular order.
     *
     * @param letters the list of available letters
     * @return the list of matching words
     */
    public List<String> wordsUsingAllLetters(String letters) {
        // Not yet implemented.
        return null;
    }

    /**
     * Returns the list of all legal words matching the specified regular expression.
     * For example, if we're using a normal English legal word list and regex="^t.a.l$",
     * the resulting list will contain "trail" and "trawl".
     *
     * Matches are case-insensitive. The list of words generated is not guaranteed
     * to be in any particular order.
     *
     * @param regex the regular expression
     * @return the list of matching words
     */
    public List<String> wordsMatchingRegularExpression(String regex) {
        // Not yet implemented.
        return null;
    }

    /**
     * Returns a copy of the specified list, in decreasing order of word length.
     * Words of identical length will appear in alphabetical order (or, more accurately,
     * in increasing order based on the String.compare method).
     *
     * @param wordList the original list
     * @return the sorted list
     */
    public List<String> wordListOrderedBySize(List<String> wordList) {
        // Not yet implemented.
        return null;
    }

    public static void main(String[] args){
        System.out.println("hello world!");
    }
}
