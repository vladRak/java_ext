package project_String;

import project_String.models.impl.Punctuation;
import project_String.models.impl.Sentence;
import project_String.models.impl.Text;
import project_String.models.impl.Word;
import project_String.parsers.SentenceElementsParser;
import project_String.parsers.SentencesParser;
import project_String.utils.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(
                    new FileInputStream("./file.txt"),
                    Charset.forName("UTF-8"));

            SentencesParser sentencesParser = new SentencesParser(inputStreamReader);
            List<String> sentences = sentencesParser.parseSentences();
            System.out.println(sentences.size());
            sentences.stream().forEach(string -> System.out.println(string));

            final int[] counter = {0};

            List<Sentence> sentences1 = new ArrayList<>();

            for (String sent : sentences) {
                Sentence sentence = new Sentence(SentenceElementsParser
                        .parseSentenceElements(sent));

                sentences1.add(sentence);
            }

            System.out.println("Sentences START................................................");

            sentences1.stream().forEach(sentence -> System.out.println(sentence));

            System.out.println("Sentences END................................................");

            System.out.println("Words size: " + Word.cacheSize());
            System.out.println("Punct size: " + Punctuation.cacheSize());
            System.out.println("Counter: " + counter[0]);

            Text text = new Text(sentences1);
            text.sortWordsByVowelsRatio().stream().forEach(word -> System.out.println
                    (word + " vowels: " + StringUtils.countVowels(word.toString()) + " ratio: " + StringUtils.ratioOfVowels(word.toString())));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
