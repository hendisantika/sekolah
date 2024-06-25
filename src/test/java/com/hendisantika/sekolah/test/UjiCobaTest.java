package com.hendisantika.sekolah.test;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.junit.jupiter.api.Test;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/03/20
 * Time: 17.06
 */
class UjiCobaTest {

    @Test
    void stripTagsTest() {
        String unsafe = "<p><a href='https://example.com/' onclick='stealCookies()'>Link</a></p>";
        String unsafe2 = "<p>Create an Angular 7 + Google Authenticator + Node JS Web App with Two-Factor " +
                "Authentication<br></p>";

        String safe = Jsoup.clean(unsafe2, Safelist.basic());
        String safeLagi = Jsoup.clean(unsafe, Safelist.basic());
        System.out.println("=================  stripTagsTest  =================");
        System.out.println("Hasilnya: " + safe);
        System.out.println("hasilnya: " + safeLagi);
    }

    @Test
    void pregReplaceTest() {
        String str = "word <a href=\"word\">word</word>word word";
        str = str.replaceAll("/[^a-z |{}!\"-_]/", "");
        System.out.println("=================  pregReplaceTest  =================");
        System.out.println(str);
    }
}
