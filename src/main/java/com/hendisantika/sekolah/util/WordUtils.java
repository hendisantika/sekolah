package com.hendisantika.sekolah.util;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/03/20
 * Time: 14.04
 */
@Component
public class WordUtils {
    public static int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] words = input.split("\\s+");
        return words.length;
    }

    public static String wordLimit(String words, int maxWords) {
        StringBuilder result = new StringBuilder();
        String[] temp = words.split("\\s+");
        for (int i = 0; i < maxWords; i++) {
            result.append(temp[i]).append(" ");
        }

        return result.toString();
    }

    public static String stripTags(String unsafeString) {
        return Jsoup.clean(unsafeString, Safelist.basic());
    }

    public static String pregReplace(String pregReplace) {
        return pregReplace.replaceAll("/[^a-zA-Z0-9 &%|{.}=,?!*()\"-_+$@;:<>']/", "");
    }
}
