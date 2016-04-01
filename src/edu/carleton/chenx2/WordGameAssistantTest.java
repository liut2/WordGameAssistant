package edu.carleton.chenx2;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by chenx2 on 4/1/16.
 */
public class WordGameAssistantTest {

    private WordGameAssistant wordGameAssistant;
    @Before
    public void setUp() throws Exception {
        String[] dic = {"wow", "woe", "owe","we", "wee",
                "ewe", "woo", "race", "care","acre", "trail","trawl"};
        this.wordGameAssistant = new WordGameAssistant(dic);
    }

    @After
    public void tearDown() throws Exception {
        this.wordGameAssistant = null;
    }

    /**
     * This block of codes consists of all the test functions for WordsUsingOnlyLetters() methods,
     * including typical string, empty string, null string, string without repetitive letters, string with upper case letters, as input
     * @throws Exception
     */
    @Test
    public void testWordsUsingOnlyLettersTypical() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingOnlyLetters("woew");
        List<String> result = new ArrayList<String>(Arrays.asList("wow", "woe", "owe","we"));
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        result = this.wordGameAssistant.wordListOrderedBySize(result);
        Assert.assertEquals("Typical test failed", result, list);
    }

    @Test
    public void testWordsUsingOnlyLettersEmpty() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingOnlyLetters("");
        List<String> result = new ArrayList<String>();
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        result = this.wordGameAssistant.wordListOrderedBySize(result);
        Assert.assertEquals("Empty test failed", result, list);
    }

    @Test
    public void testWordsUsingOnlyLettersWithRepetition() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingOnlyLetters("woe");
        List<String> result = new ArrayList<String>(Arrays.asList("woe", "owe","we"));
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        result = this.wordGameAssistant.wordListOrderedBySize(result);
        Assert.assertEquals("With Repetition test failed", result, list);
    }

    @Test
    public void testWordsUsingOnlyLettersNull() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingOnlyLetters(null);
        Assert.assertEquals("Null test failed", null, list);
    }

    @Test
    public void testWordsUsingOnlyLettersCase() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingOnlyLetters("WOE");
        List<String> result = new ArrayList<String>(Arrays.asList("woe", "owe","we"));
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        result = this.wordGameAssistant.wordListOrderedBySize(result);
        Assert.assertEquals("Uppercase test failed", result, list);
    }
    /**
     * This block of codes consists of all the test functions for WordsUsingLettersAllowingRepetition() methods,
     * including typical string, empty string, null string, string without using repetitive letters, string with upper case letters, as input
     * @throws Exception
     */
    @Test
    public void testWordsUsingLettersAllowingRepetitionTypical() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingLettersAllowingRepetition("woe");
        List<String> expected = new ArrayList<String>(Arrays.asList("wow", "woe", "owe", "wee",
                 "ewe", "woo", "we"));
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        expected = this.wordGameAssistant.wordListOrderedBySize(expected);
        Assert.assertEquals("Typical test failed", expected, list);
    }

    @Test
    public void testWordsUsingLettersAllowingRepetitionNull() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingLettersAllowingRepetition(null);
        Assert.assertEquals("Null test failed", null, list);
    }

    @Test
    public void testWordsUsingLettersAllowingRepetitionEmpty() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingLettersAllowingRepetition("");
        List<String> result = new ArrayList<String>();
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        result = this.wordGameAssistant.wordListOrderedBySize(result);
        Assert.assertEquals("Empty test failed", result, list);
    }

    @Test
    public void testWordsUsingLettersAllowingRepetitionCase() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingLettersAllowingRepetition("WOW");
        List<String> expected = new ArrayList<String>(Arrays.asList("wow", "woe", "owe", "wee",
                "ewe", "woo", "we"));
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        expected = this.wordGameAssistant.wordListOrderedBySize(expected);
        Assert.assertEquals("Uppercase test failed", expected, list);
    }
    public void testWordsUsingLettersAllowingRepetitionWithoutUsingRepetition() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingLettersAllowingRepetition("woe");
        List<String> expected = new ArrayList<String>(Arrays.asList("woe", "owe","we"));
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        expected = this.wordGameAssistant.wordListOrderedBySize(expected);
        Assert.assertEquals("Without using repetition test failed", expected, list);
    }
    /**
     * This block of codes consists of all the test functions for WordsUsingLettersAllowingRepetition() methods,
     * including typical string, empty string, null string, string with upper case letters, as input
     * @throws Exception
     */

    @Test
    public void testWordsUsingAllLettersTypical() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingAllLetters("ecra");
        List<String> expected = new ArrayList<String>(Arrays.asList("race", "care","acre"));
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        expected = this.wordGameAssistant.wordListOrderedBySize(expected);
        Assert.assertEquals("Typical test failed", expected, list);
    }

    @Test
    public void testWordsUsingAllLettersNull() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingAllLetters(null);
        Assert.assertEquals("Null test failed", null, list);
    }

    @Test
    public void testWordsUsingAllLettersEmpty() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingAllLetters("");
        List<String> result = new ArrayList<String>();
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        result = this.wordGameAssistant.wordListOrderedBySize(result);
        Assert.assertEquals("Empty test failed", result, list);
    }

    @Test
    public void testWordsUsingAllLettersCase() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingAllLetters("ECRA");
        List<String> expected = new ArrayList<String>(Arrays.asList("race", "care","acre"));
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        expected = this.wordGameAssistant.wordListOrderedBySize(expected);
        Assert.assertEquals("Uppercase test failed", expected, list);
    }

    /**
     * This block of codes consists of all the test functions for WordsMatchingRegularExpression() methods,
     * including typical string, string that matches all words, null string, string that is part of the substring, string with upper case letters, as input
     * @throws Exception
     */

    @Test
    public void testWordsMatchingRegularExpressionTypical1() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingAllLetters("^t.a.l$");
        List<String> expected = new ArrayList<String>(Arrays.asList("trail","trawl"));
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        expected = this.wordGameAssistant.wordListOrderedBySize(expected);
        Assert.assertEquals("Typical test 1 failed", expected, list);
    }

    @Test
    public void testWordsMatchingRegularExpressionTypical2() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingAllLetters("^w.*e$");
        List<String> expected = new ArrayList<String>(Arrays.asList("woe", "we", "wee"));
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        expected = this.wordGameAssistant.wordListOrderedBySize(expected);
        Assert.assertEquals("Typical test 2 failed", expected, list);
    }

    @Test
    public void testWordsMatchingRegularExpressionTypical3() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingAllLetters("w.*");
        List<String> expected = new ArrayList<String>(Arrays.asList("wow", "woe","we", "wee",
                "ewe", "woo"));
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        expected = this.wordGameAssistant.wordListOrderedBySize(expected);
        Assert.assertEquals("Typical test 3 failed", expected, list);
    }

    @Test
    public void testWordsMatchingRegularExpressionAllWords() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingAllLetters("*");
        List<String> expected = new ArrayList<String>(Arrays.asList("wow", "woe", "owe","we", "wee",
                "ewe", "woo", "race", "care","acre", "trail","trawl"));
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        expected = this.wordGameAssistant.wordListOrderedBySize(expected);
        Assert.assertEquals("All words test failed", expected, list);
    }

    @Test
    public void testWordsMatchingRegularExpressionEmpty() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingAllLetters("kfgjj");
        List<String> expected = new ArrayList<String>();
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        expected = this.wordGameAssistant.wordListOrderedBySize(expected);
        Assert.assertEquals("Empty test failed", expected, list);
    }

    @Test
     public void testWordsMatchingRegularExpressionNull() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingAllLetters(null);
        Assert.assertEquals("Null test failed", null, list);
    }

    @Test
    public void testWordsMatchingRegularExpressionSubstring() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingAllLetters("ow");
        List<String> expected = new ArrayList<String>(Arrays.asList("wow", "owe"));
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        expected = this.wordGameAssistant.wordListOrderedBySize(expected);
        Assert.assertEquals("Substring test failed", null, list);
    }

    @Test
    public void testWordsMatchingRegularExpressionCase() throws Exception {
        List<String> list = wordGameAssistant.wordsUsingAllLetters("^T.A.L$");
        List<String> expected = new ArrayList<String>(Arrays.asList("trail","trawl"));
        list = this.wordGameAssistant.wordListOrderedBySize(list);
        expected = this.wordGameAssistant.wordListOrderedBySize(expected);
        Assert.assertEquals("Uppercase test failed", expected, list);
    }

    /**
     * This block of codes consists of all the test functions for WordListOrderedBySizeTypical() methods,
     * including typical string, string that matches all words, null string, string that is part of the substring, string with upper case letters, as input
     * @throws Exception
     */

    @Test
    public void testWordListOrderedBySizeTypical() throws Exception {
        List<String> list = new ArrayList<String>(Arrays.asList("wow", "woe", "owe","we"));
        List<String> expected = new ArrayList<String>(Arrays.asList("owe", "woe", "wow","we"));
        list = wordGameAssistant.wordListOrderedBySize(list);
        expected = wordGameAssistant.wordListOrderedBySize(expected);
        Assert.assertEquals("Typical test failed", expected, list);
    }

    @Test
    public void testWordListOrderedBySizeEmpty() throws Exception {
        List<String> list = wordGameAssistant.wordListOrderedBySize(new ArrayList<String>());
        List<String> result = new ArrayList<String>();
        Assert.assertEquals("Empty test failed", result, list);
    }

    @Test
    public void testWordListOrderedBySizeNull() throws Exception {
        List<String> expected = wordGameAssistant.wordListOrderedBySize(null);
        Assert.assertEquals("Null test failed", expected, null);
    }


}