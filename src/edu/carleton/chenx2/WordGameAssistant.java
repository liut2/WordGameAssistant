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

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;


public class WordGameAssistant {
    private String[] dic;
    /**
     * Initializes this WordGameAssistant given a word list contained in
     * the specified file. The file must consist of one word per line.
     *
     * @param dictionaryFilePath the path to the dictionary file
     */
    public WordGameAssistant(String dictionaryFilePath) {
//        String token1 = "";
//        Scanner inFile1 = new Scanner(new File(dictionaryFilePath)).useDelimiter(",\\s*");
//        List<String> temps = new ArrayList<String>();
//        while (inFile1.hasNext()) {
//            token1 = inFile1.next();
//            temps.add(token1);
//        }
//        inFile1.close();
//        dic = temps.toArray(new String[0]);
    }

    /**
     * Initializes this WordGameAssistant given the specified list of words.
     *
     * @param wordList the words
     */
    public WordGameAssistant(String[] wordList) {
        // Not yet implemented.
        dic = wordList;
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
        List<String> words = new LinkedList();
        for (String s: dic) {
            char[] arr = letters.toCharArray();
            LinkedList character = new LinkedList();
            for(char c: arr){
                character.add(c);
            }
            boolean match = true;
            char[] list_of_char = s.toCharArray();
            for (char c: list_of_char){
                if (character.contains(c)){
                    character.removeFirstOccurrence(c);
                }else{
                    match = false;
                    break;
                }
            }
            if (match){
                words.add(s);
            }
        }
        System.out.println(words);
        return words;
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
        char[] arr = letters.toCharArray();
        List<String> words = new LinkedList();
        LinkedList list = new LinkedList();
        for(char c: arr){
            list.add(c);
        }
        LinkedList character;
        for (String s: dic) {
            character = list;
            boolean match = true;
            char[] list_of_char = s.toCharArray();
            for (char c: list_of_char){
                if (character.contains(c)){
                }else{
                    match = false;
                    break;
                }
            }
            if (match){
                words.add(s);
            }
        }
        return words;
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
        List<String> words = new LinkedList();
        for (String s: dic) {
            char[] arr = letters.toCharArray();
            LinkedList character = new LinkedList();
            for(char c: arr){
                character.add(c);
            }
            boolean match = true;
            char[] list_of_char = s.toCharArray();
            for (char c: list_of_char){
                if (character.contains(c)){
                    character.removeFirstOccurrence(c);
                }else{
                    match = false;
                    break;
                }
            }
            if (match && character.isEmpty()){
                words.add(s);
            }
        }
        System.out.println(words);
        return words;

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
        List<String> words = new LinkedList<String>();
        for (String s: dic){
            if (s.matches(regex)){
                words.add(s);
            }
        }
        System.out.println(words);
        return words;
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
        Comparator<String> x = new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                if(o1.length() > o2.length())
                    return -1;

                if(o2.length() > o1.length())
                    return 1;

                else
                    if(o1.compareTo(o2) > 0)
                        return 1;

                    if(o1.compareTo(o2) < 0)
                        return -1;

                    return 0;
            }
        };
        Collections.sort(wordList,  x);
        System.out.println(wordList.toString());
        return wordList;
    }

    public static void main(String[] args){
        System.out.println("hello world!");
    }
}
