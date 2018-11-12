package hw_3.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class ResourceBundleHelper {

    public static List<String> getSupportedLanguages(String resourceBundleName) throws IOException {
        List<String> languages = Files.walk(getPathToResourceRoot())
                .filter(s -> s.toString().endsWith(".properties"))
                .map(Path::getFileName)
                .sorted()
                .map(Path::toString)
                .filter(getPredicate(createPatternByResourceBundlesName(resourceBundleName)))
                .map(s -> s.split("_", 2))
                .filter(s -> s.length > 1)
                .map(s -> s[1].split("\\.", 2))
                .map(s -> s[0])
                .collect(toList());
        return languages;
    }

    private static Path getPathToResourceRoot() {
        return Paths.get(new File(Thread.currentThread()
                .getContextClassLoader()
                .getResource("./")
                .getFile()).getParent());
    }

    private static Predicate<String> getPredicate(Pattern pattern) {
        return pattern.asPredicate();
    }

    private static Pattern createPatternByResourceBundlesName(String resourceBundleName) {
        return Pattern.compile("^" + resourceBundleName + "(.+).properties$");
    }
}
