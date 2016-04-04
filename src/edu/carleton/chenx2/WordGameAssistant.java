// author : Xi Chen and Tao Liu
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


import java.util.*;
import java.io.*;

public class WordGameAssistant {
    class TrieNode {
        // Initialize your data structure here.
        char val;
        HashMap<Character, TrieNode> children;
        boolean isEnd;
        //constructor without val
        public TrieNode() {
            isEnd = false;
            children = new HashMap<Character, TrieNode>();
        }
        //constructor with val
        public TrieNode(char val) {
            this.val = val;
            isEnd = false;
            children = new HashMap<Character, TrieNode>();
        }
    }
    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }
        // Inserts a word into the trie.
        public void insert(String word) {
            HashMap<Character, TrieNode> curChildren = root.children;
            for (int i = 0; i < word.length(); i++){
                char curChar = word.charAt(i);
                TrieNode curNode = null;
                if (curChildren.containsKey(curChar)){
                    curNode = curChildren.get(curChar);
                }else{
                    TrieNode newNode = new TrieNode(curChar);
                    curChildren.put(curChar, newNode);
                    curNode = curChildren.get(curChar);
                }
                curChildren = curChildren.get(curChar).children;
                if (i == word.length() - 1){
                    curNode.isEnd = true;
                }
            }
        }
        // Returns if the word is in the trie.
        public boolean search(String word) {
            if (word == null || word.length() == 0){
                return false;
            }
            HashMap<Character, TrieNode> children = root.children;
            return searchHelper(word, 0, children);
        }
        public boolean searchHelper(String word, int pos, HashMap<Character, TrieNode> children){
            //base case
            if (pos == word.length() - 1){
                char lastChar = word.charAt(word.length() - 1);
                if (children.containsKey(lastChar) && children.get(lastChar).isEnd){
                    return true;
                }
                return false;
            }
            //main body
            char curChar = word.charAt(pos);
            if (!children.containsKey(curChar)){
                return false;
            }else{
                children = children.get(curChar).children;
                return searchHelper(word, pos + 1, children);
            }
        }
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0){
                return false;
            }
            HashMap<Character, TrieNode> children = root.children;
            return startHelper(prefix, 0, children);
        }
        public boolean startHelper(String word, int pos, HashMap<Character, TrieNode> children){
            //base case
            if (pos == word.length()){
                return true;
            }
            //main body
            char curChar = word.charAt(pos);
            if (!children.containsKey(curChar)){
                return false;
            }else{
                children = children.get(curChar).children;
                return startHelper(word, pos + 1, children);
            }
        }
    }
    private Trie trie = new Trie();
    private ArrayList<String> dic = new ArrayList<String>();
    /**
     * Initializes this WordGameAssistant given a word list contained in
     * the specified file. The file must consist of one word per line.
     *
     * @param dictionaryFilePath the path to the dictionary file
     */
    public WordGameAssistant(String dictionaryFilePath) {
        //create file object
        String inputFilePath = dictionaryFilePath;
        File file = new File(inputFilePath);
        Scanner sc = null;
        //try to read the file from disk, catch the error if the file doesn't exist
        try{
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }
        //read line by line
        while (sc.hasNextLine()){
            String line = sc.nextLine().toLowerCase();
            this.trie.insert(line);
            this.dic.add(line);
        }
    }

    /**
     * Initializes this WordGameAssistant given the specified list of words.
     *
     * @param wordList the words
     */
    public WordGameAssistant(String[] wordList) {
        // read legal words into trie
        for (String str : wordList){
            this.trie.insert(str);
        }
        this.dic = new ArrayList<String>(Arrays.asList(wordList));
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
        //edge case
        List<String> result = new ArrayList<String>();
        if (letters == null || letters.length() == 0){
            return result;
        }
        letters = letters.toLowerCase();
        //convert the letters into char array and sort for use.
        //create a boolean array visited to record which letter has already been used
        char[] charInput = letters.toCharArray();
        Arrays.sort(charInput);
        boolean[] visited = new boolean[letters.length()];
        //call recursive function
        wordsUsingOnlyLettersHelper(charInput, visited, "", result);
        return result;
    }
    public void wordsUsingOnlyLettersHelper(char[] charInput, boolean[] visited, String temp, List<String> result){
        //every level of recursion, check to see if temp string is in the dic
        if (this.trie.search(temp)){
            result.add(temp);
        }
        //base case
        if (temp.length() == charInput.length){
            return;
        }
        //main body
        for (int i = 0; i < charInput.length; i++){
            char ch = charInput[i];
            if (visited[i]){
                continue;
            }
            if (i > 0 && charInput[i] == charInput[i - 1] && visited[i - 1] == false){
                continue;
            }
            visited[i] = true;
            //next level
            wordsUsingOnlyLettersHelper(charInput, visited, temp + ch, result);
            //backtrack
            visited[i] = false;
        }
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
        //edge case
        List<String> result = new ArrayList<String>();
        if (letters == null || letters.length() == 0){
            return result;
        }
        letters = letters.toLowerCase();
        wordsUsingLettersAllowingRepetitionHelper(letters, this.trie.root.children, "", result);
        return result;
    }
    public void wordsUsingLettersAllowingRepetitionHelper(String letters, HashMap<Character, TrieNode> children, String temp, List<String> result){
        if (this.trie.search(temp)){
            result.add(temp);
        }
        //base case
        if (children.size() == 0){
            return;
        }
        //main body
        for (int i = 0; i < letters.length(); i++){
            char ch = letters.charAt(i);
            if (children.containsKey(ch)){
                wordsUsingLettersAllowingRepetitionHelper(letters, children.get(ch).children, temp + ch, result);
            }
        }
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
        //edge case
        List<String> result = new ArrayList<String>();
        if (letters == null || letters.length() == 0){
            return result;
        }
        letters = letters.toLowerCase();
        //convert the letters into char array and sort for use.
        //create a boolean array visited to record which letter has already been used
        char[] charInput = letters.toCharArray();
        Arrays.sort(charInput);
        boolean[] visited = new boolean[letters.length()];
        //call recursive function
        wordsUsingAllLettersHelper(charInput, visited, "", result);
        return result;
    }
    public void wordsUsingAllLettersHelper(char[] charInput, boolean[] visited, String temp, List<String> result){
        //base case
        if (temp.length() == charInput.length){
            if (this.trie.search(temp)){
                result.add(temp);
            }
            return;
        }
        //main body
        for (int i = 0; i < charInput.length; i++){
            char ch = charInput[i];
            if (visited[i]){
                continue;
            }
            if (i > 0 && charInput[i] == charInput[i - 1] && visited[i - 1] == false){
                continue;
            }
            visited[i] = true;
            //next level
            wordsUsingAllLettersHelper(charInput, visited, temp + ch, result);
            //backtrack
            visited[i] = false;
        }
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
        if (regex == null || regex.length() == 0){
            return  words;
        }
        regex = regex.toLowerCase();
        //System.out.println(regex);
        for (String s: dic){
            if (s.matches(regex)){
                words.add(s);
            }
        }
        //System.out.println(words);
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
        if (wordList == null || wordList.size() == 0){
            return new ArrayList<String>();
        }
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
        //System.out.println(wordList.toString());
        return wordList;
    }


    public static void main(String[] args){
        if (args.length != 2 && args.length != 3 ){
            System.out.println(args.length);
            System.out.println("usage: java WordGameAssistant [--dictionary=path-to-dictionary-file] action letters");
            System.exit(1);
        }
        String dicPath = null;
        String action;
        String letters;
        if (args.length == 3){
            dicPath = args[0];
            action = args[1];
            letters = args[2];
        }else{
            action = args[0];
            letters = args[1];
        }
        //construct the wordsAssitant object
        WordGameAssistant wordGameAssistant = dicPath == null? new WordGameAssistant("dictionary.txt"): new WordGameAssistant(dicPath);
        //actions: words, use-all-letters, allow-repetition, and regex
        //wordsUsingOnlyLetters, wordsUsingAllLetters, wordsUsingLettersAllowingRepetition, and wordsMatchingRegularExpression, respectively.
        List<String> result = new ArrayList<String>();
        switch(action){
            case "words":
                result = wordGameAssistant.wordsUsingOnlyLetters(letters);
                break;
            case "use-all-letters":
                result = wordGameAssistant.wordsUsingAllLetters(letters);
                break;
            case "allow-repetition":
                result = wordGameAssistant.wordsUsingLettersAllowingRepetition(letters);
                break;
            case "regex":
                result = wordGameAssistant.wordsMatchingRegularExpression(letters);
                break;
            default:
                break;
        }
        wordGameAssistant.wordListOrderedBySize(result);
        System.out.println(result.toString());
    }
}
