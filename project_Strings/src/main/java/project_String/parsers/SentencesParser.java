package project_String.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SentencesParser {

    private final BufferedReader bufferedReader;
    private final StringBuilder buffer = new StringBuilder();
    public final static Pattern DEFAULT_PATTERN = Pattern
            .compile("[\\w+\\s[\\p{Punct}&&[^.!?]]*]+[.!?]");
    private int bufferSizeBeforeMatch = 0;

    public SentencesParser(Reader reader) {
        bufferedReader = new BufferedReader(reader);
    }

    public List<String> parseSentences() {
        return parseSentencesWithPattern(DEFAULT_PATTERN);
    }

    public List<String> parseSentences(Pattern pattern) {
        return parseSentencesWithPattern(pattern);
    }

    private List<String> parseSentencesWithPattern(Pattern pattern) {
        List<String> sentences = new ArrayList<>();
        String sCurLine;
        try {
            while ((sCurLine = bufferedReader.readLine()) != null) {
                bufferSizeBeforeMatch = buffer.length();
                sentences.addAll(parseSentencesOrAddToBuffer(sCurLine, pattern));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sentences;
    }

    private List<String> parseSentencesOrAddToBuffer(String textLine, Pattern pattern) {
        List<String> sentences = new ArrayList<>(5);
        buffer.append(excludeExcessSpaces(textLine));

        Matcher matcher = pattern.matcher(textLine);

        while (true) {
            if (matcher.find()) {
                sentences.add(extractMatched(matcher));
            } else break;
        }
        return sentences;
    }

    private String excludeExcessSpaces(String string) {
        addOneSpaceInToEnd();
        return string.replaceAll("\\s+", "\u0020");
    }

    private void addOneSpaceInToEnd() {
        if (bufferHasChars()) {
            int i = buffer.length() - 1;
            String s = buffer.substring(i);
            if (!s.endsWith("\u0020")) buffer.append("\u0020");
        }
    }

    private boolean bufferHasChars() {
        if (buffer.length() > 0) return true;
        else return false;
    }

    private String extractMatched(Matcher matcher) {

        String sentence;
        if (bufferSizeBeforeMatch > 0) {
            String matched = matcher.group();
            sentence = buffer.substring(0, bufferSizeBeforeMatch) + " " + matched;
            buffer.delete(0, sentence.length());
            bufferSizeBeforeMatch = 0;
            sentence = sentence.trim();
        } else {
            sentence = matcher.group();
            buffer.delete(0, sentence.length());
            sentence = sentence.trim();
        }
        return sentence;
    }
}



