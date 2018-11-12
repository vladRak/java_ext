package project_String.models.impl;

import project_String.models.TextElement;
import project_String.models.WordOperation;
import project_String.utils.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Word implements TextElement, WordOperation {

    private final StringBuilder word = new StringBuilder();
    private int numberOfVowels;

    private Word(String word) {
        this.word.append(word);
    }

    public int ratioOfVowels() {
        return StringUtils.ratioOfVowels(getValue());
    }

    public int getNumberOfVowels(){
        if (numberOfVowels == 0) numberOfVowels = StringUtils.countVowels(getValue());
        return numberOfVowels;
    }

    public static int cacheSize(){
        return WordsCache.cacheSize();
    }

    public static Word createWord(String word) {
        return WordsCache.addWord(new Word(word));
    }

    @Override
    public void firstLetterToUpperCase() {
        char first = word.charAt(0);
        word.setCharAt(0, Character.toUpperCase(first));
    }

    @Override
    public String getValue() {
        return word.toString();
    }

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word someWord = (Word) o;

        return word != null ? word.equals(someWord.word) : someWord.word == null;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getValue().toCharArray());
    }

    private static class WordsCache {

        private static final Map<Integer, Word> words = new HashMap<>();

        public static Word addWord(Word word) {
            Word wordFromCache = words.get(word.hashCode());
            if (wordFromCache == null) {
                words.put(word.hashCode(), word);
                wordFromCache = word;
            }
            return wordFromCache;
        }

        public static int cacheSize(){
            return words.size();
        }
    }
}
