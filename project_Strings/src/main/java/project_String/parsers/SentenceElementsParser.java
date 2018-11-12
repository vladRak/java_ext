package project_String.parsers;

import project_String.models.impl.Punctuation;
import project_String.models.TextElement;
import project_String.models.impl.Word;

import java.util.ArrayList;
import java.util.List;

public final class SentenceElementsParser {

    private final static StringBuilder buffer = new StringBuilder();
    private final static List<TextElement> sentenceElements = new ArrayList<>();

    private SentenceElementsParser() {
    }

    public static List<TextElement> parseSentenceElements(String sentence) {

        for (int i = 0; i < sentence.length(); i++) {
            char character = sentence.charAt(i);

            processCharacter(character);
        }

        List<TextElement> localeSentenceElements = new ArrayList<>(sentenceElements);
        sentenceElements.clear();

        return localeSentenceElements;
    }

    private static char processCharacter(char character) {
        final char UNSUPPORTED_CHARACTER = (char) -1;

        if (CharacterPattern.isWordCharacter(character)) {
            buffer.append(character);
        } else if (CharacterPattern.isWhitespace(character)) {
            addWord();
        } else if (CharacterPattern.isPunctuation(character)) {
            addWord();
            addPunctuation(character);
        } else return UNSUPPORTED_CHARACTER;
        return character;
    }

    private static Word addWord() {
        Word word = null;
        if (bufferHasChars()) {
            word = Word.createWord(buffer.toString());
            sentenceElements.add(word);
            buffer.setLength(0);
        }
        return word;
    }

    private static Punctuation addPunctuation(char character) {
        Punctuation punctuation = Punctuation.createPunctuation(character);
        sentenceElements.add(punctuation);
        return punctuation;
    }

    private static boolean bufferHasChars() {
        if (buffer.length() > 0) return true;
        else return false;
    }
}