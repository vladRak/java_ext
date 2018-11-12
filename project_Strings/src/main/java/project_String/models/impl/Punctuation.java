package project_String.models.impl;

import project_String.models.TextElement;

import java.util.HashMap;
import java.util.Map;

public class Punctuation implements TextElement {

    private final char punctuation;

    private Punctuation(char punctuation) {
        this.punctuation = punctuation;
    }

    public static int cacheSize() {
        return Punctuation.PunctuationCache.cacheSize();
    }

    public static Punctuation createPunctuation(char punctuation) {
        return Punctuation
                .PunctuationCache
                .addPunctuation(new Punctuation(punctuation));
    }

    @Override
    public String getValue() {
        return String.valueOf(punctuation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Punctuation)) return false;

        Punctuation that = (Punctuation) o;

        return punctuation == that.punctuation;
    }

    @Override
    public int hashCode() {
        return punctuation;
    }

    @Override
    public String toString() {
        return getValue();
    }

    private static class PunctuationCache {

        private static final Map<Integer, Punctuation> punctuations = new HashMap<>();

        public static Punctuation addPunctuation(Punctuation punctuation) {
            Punctuation punctuationsFromCache = punctuations.get(punctuations.hashCode());
            if (punctuationsFromCache == null) {
                punctuations.put(punctuation.hashCode(), punctuation);
                punctuationsFromCache = punctuation;
            }
            return punctuationsFromCache;
        }

        public static int cacheSize() {
            return punctuations.size();
        }
    }

}
