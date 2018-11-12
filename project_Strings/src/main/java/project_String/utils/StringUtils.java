package project_String.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private StringUtils() {
    }

    public static int countVowels(String str) {
        Matcher matcher = Pattern.compile("[aeiouAEIOU]").matcher(str);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }

    public static int ratioOfVowels(String str) {
        int vowels = countVowels(str);
        if (vowels > 0) return (vowels * 100) / str.length();
        else return 0;
    }
}
