package project_String.parsers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.List;

public class SentencesParserTest {

    private String sentenceString;
    private InputStreamReader inputStreamReader;

    @Before
    public void setUp() throws Exception {
        sentenceString = "Create\n" +
                "an\n" +
                "application! that meets the requirements. given in the task. Inheritance" +
                " apply only in those ?\n";

        inputStreamReader = new InputStreamReader(
                new ByteArrayInputStream(sentenceString
                        .getBytes("UTF-8")));
    }

    @After
    public void tearDown() throws Exception {
        inputStreamReader.close();
        inputStreamReader = null;
        sentenceString = null;

    }

    @Test
    public void parseSentencesWithOutEndInOneLine() throws Exception {
        SentencesParser sentencesParser = new SentencesParser(inputStreamReader);

        List<String> sentences = sentencesParser.parseSentences();

        Assert.assertEquals(4, sentences.size());
    }
}