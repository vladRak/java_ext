package project_String.models.impl;

import project_String.models.TextOperations;

import java.util.List;
import java.util.stream.Collectors;

public class Text implements TextOperations {

    private final List<Sentence> sentences;

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public List<Word> sortWordsByVowelsRatio() {
        return sentences.stream()
                .flatMap(sentence -> sentence.getElements().stream())
                .distinct()
                .filter(textElement -> textElement instanceof Word)
                .map(textElement -> (Word) textElement)
                .sorted((word1, word2) -> word2.ratioOfVowels() - word1.ratioOfVowels())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        final int size = sentences.size();
        for (int i = 0; i < size; i++) {
            sb.append(sentences.get(i));
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;

        Text text = (Text) o;

        return sentences.equals(text.sentences);
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (Sentence s : sentences)
            result = 31 * result + s.hashCode();
        return result;
    }
}
