package project_String.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum CharacterPattern {

    WORD_CHARACTER("[\\w]"),
    WHITESPACE_CHARACTER("[\\s]"),
    PUNCTUATION("[\\p{Punct}]");

    private String pattern;

    CharacterPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public static boolean isWordCharacter(char character) {
        return matchedByPattern
                (character, WORD_CHARACTER.getPattern());
    }

    public static boolean isWhitespace(char character) {
        return matchedByPattern
                (character, WHITESPACE_CHARACTER.getPattern());
    }

    public static boolean isPunctuation(char character) {
        return matchedByPattern
                (character, PUNCTUATION.getPattern());
    }

    private static boolean matchedByPattern(char character, String pattern) {
        Matcher matcher = Pattern
                .compile(pattern)
                .matcher(String.valueOf(character));
        return matcher.find();
    }
}
