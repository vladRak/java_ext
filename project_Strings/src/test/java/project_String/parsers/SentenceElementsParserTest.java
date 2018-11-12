package project_String.parsers;

import project_String.models.TextElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SentenceElementsParserTest {

    private String sentenceString;

    @Before
    public void setUp() throws Exception {
        sentenceString = "Create an application!";
    }

    @After
    public void tearDown() throws Exception {
        sentenceString = null;
    }


    @Test
    public void parseSentenceElements() throws Exception {
        List<TextElement> textElements = SentenceElementsParser
                .parseSentenceElements(sentenceString);

        Assert.assertNotNull(textElements);
        Assert.assertEquals(4, textElements.size());
    }

}