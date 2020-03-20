package com.hendisantika.sekolah.util;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/03/20
 * Time: 14.04
 */
public class WordUtil {
    public static int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] words = input.split("\\s+");
        return words.length;
    }

    public static String wordLimit(String words, int maxWords) {
        String result = "";
        String[] temp = words.split("\\s+");
        for (int i = 0; i < maxWords; i++) {
            result += temp[i] + " ";
        }

        return result;
    }
}
