package com.hendisantika.sekolah.util;

import com.hendisantika.sekolah.dto.UserAgentInfo;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/03/20
 * Time: 06.35
 */
@Slf4j
public class WebUtils {
    public static UserAgentInfo getUserAgent(HttpServletRequest request) {
        String userAgent = "Unknown";
        String osType = "Unknown";
        String osVersion = "Unknown";
        String browserType = "Unknown";
        String browserVersion = "Unknown";
        String deviceType = "Unknown";

        try {
            userAgent = request.getHeader("User-Agent");
            //userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:68.0) Gecko/20100101 Firefox/68.0";
            //userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76
            // .0.3809.100 Safari/537.36";
            //userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64
            // .0.3282.140 Safari/537.36 Edge/17.17134";
            //userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 12_3_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like
            // Gecko) Version/12.1.1 Mobile/15E148 Safari/604.1";
            boolean exceptionTest = false;
            if (exceptionTest) throw new Exception("EXCEPTION TEST");

            if (userAgent.indexOf("Windows NT") >= 0) {
                osType = "Windows";
                osVersion = userAgent.substring(userAgent.indexOf("Windows NT ") + 11, userAgent.indexOf(";"));

            } else if (userAgent.indexOf("Mac OS") >= 0) {
                osType = "Mac";
                osVersion = userAgent.substring(userAgent.indexOf("Mac OS ") + 7, userAgent.indexOf(")"));

                if (userAgent.indexOf("iPhone") >= 0) {
                    deviceType = "iPhone";
                } else if (userAgent.indexOf("iPad") >= 0) {
                    deviceType = "iPad";
                }

            } else if (userAgent.indexOf("X11") >= 0) {
                osType = "Unix";
                osVersion = "Unknown";

            } else if (userAgent.indexOf("android") >= 0) {
                osType = "Android";
                osVersion = "Unknown";
            }
            log.trace("end of os section");

            if (userAgent.contains("Edge/")) {
                browserType = "Edge";
                browserVersion = userAgent.substring(userAgent.indexOf("Edge")).split("/")[1];

            } else if (userAgent.contains("Safari/") && userAgent.contains("Version/")) {
                browserType = "Safari";
                browserVersion = userAgent.substring(userAgent.indexOf("Version/") + 8).split(" ")[0];

            } else if (userAgent.contains("OPR/") || userAgent.contains("Opera/")) {
                browserType = "Opera";
                browserVersion = userAgent.substring(userAgent.indexOf("OPR")).split("/")[1];

            } else if (userAgent.contains("Chrome/")) {
                browserType = "Chrome";
                browserVersion = userAgent.substring(userAgent.indexOf("Chrome")).split("/")[1];
                browserVersion = browserVersion.split(" ")[0];

            } else if (userAgent.contains("Firefox/")) {
                browserType = "Firefox";
                browserVersion = userAgent.substring(userAgent.indexOf("Firefox")).split("/")[1];
            }
            log.trace("end of browser section");

        } catch (Exception ex) {
            log.error("ERROR: " + ex);
        }

        UserAgentInfo agentInfo = UserAgentInfo.builder()
                .userAgent(userAgent)
                .browserType(browserType)
                .browserVersion(browserVersion)
                .deviceType(deviceType)
                .osType(osType)
                .osVersion(osVersion)
                .build();

        log.info(
                "\n userAgent: " + userAgent
                        + "\n osType: " + osType
                        + "\n osVersion: " + osVersion
                        + "\n browserType: " + browserType
                        + "\n browserVersion: " + browserVersion
                        + "\n deviceType: " + deviceType
        );
        return agentInfo;
    }
}
