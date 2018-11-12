package project_String.models.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import project_String.parsers.SentenceElementsParser;

import java.util.Arrays;
import java.util.List;

public class TextTest {

    private Text text;
    private Sentence sentence;
    private String sentenceString;

    @Before
    public void setUp() throws Exception {
        sentenceString = "application Create an!";

        sentence = new Sentence(SentenceElementsParser
                .parseSentenceElements(sentenceString));

        text = new Text(Arrays.asList(sentence));
    }

    @After
    public void tearDown() throws Exception {
        text = null;
        sentenceString = null;
        sentence = null;
    }

    @Test
    public void sortWordsByVowelsRatio() throws Exception {
        List<Word> words = Arrays.asList(
                Word.createWord("Create"),
                Word.createWord("an"),
                Word.createWord("application"));

        List<Word> wordsFromText = text.sortWordsByVowelsRatio();

        Assert.assertEquals(words,wordsFromText);
    }
}