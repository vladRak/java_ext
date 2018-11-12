package project_String.models.impl;

import project_String.models.TextElement;

import java.util.List;

public class Sentence {

    private final List<TextElement> elements;

    public Sentence(List<TextElement> elements) {
        this.elements = elements;
    }

    public List<TextElement> getElements() {
        return elements;
    }

    public int length(){
        return toString().length();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        final int size = elements.size();
        for (int i = 0; i < size - 1; i++) {
            sb.append(elements.get(i));
            TextElement next = elements.get(i + 1);
            if (!(next instanceof Punctuation))
                sb.append(' ');
        }
        sb.append(elements.get(size - 1));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;

        Sentence sentence = (Sentence) o;

        return elements.equals(sentence.elements);
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (TextElement e : elements)
            result = 31 * result + e.hashCode();
        return result;
    }
}
