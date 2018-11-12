package project_String.models.impl;

import org.junit.Assert;
import org.junit.Test;

public class WordsCacheTest {
    @Test
    public void createOneWordTenTimeInCacheOneWord() throws Exception {
        final String string = "Test";
        final int wordInCache = Word.cacheSize();
        final int addedWords = 1;

        for (int i = 0; i < 10; i++) {
            Word word = Word.createWord(string);
        }

        Assert.assertEquals(wordInCache + addedWords, Word.cacheSize());
    }
}
//Runtime rt = Runtime.getRuntime();
//System.out.println("Used: "+(rt.totalMemory()-rt.freeMemory()));
//System.out.println("Free: "+rt.freeMemory());
//System.out.println("Total: "+rt.totalMemory());