package com.hendisantika.sekolah.util;

import com.hendisantika.sekolah.dto.UserAgentInfo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import net.sf.uadetector.OperatingSystem;
import net.sf.uadetector.ReadableDeviceCategory;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.VersionNumber;

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

            } else if (userAgent.indexOf("android") >= 0 || userAgent.contains("Android")) {
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

    public static UserAgentInfo showUserAgentInfo(ReadableUserAgent agent) {
        // type
        log.info("Browser type: " + agent.getType().getName());
        log.info("Browser name: " + agent.getName());
        VersionNumber browserVersion = agent.getVersionNumber();
        log.info("Browser version: " + browserVersion.toVersionString());
        log.info("Browser version major: " + browserVersion.getMajor());
        log.info("Browser version minor: " + browserVersion.getMinor());
        log.info("Browser version bug fix: " + browserVersion.getBugfix());
        log.info("Browser version extension: " + browserVersion.getExtension());
        log.info("Browser producer: " + agent.getProducer());

        // operating system
        OperatingSystem os = agent.getOperatingSystem();
        log.info("OS Name: " + os.getName());
        log.info("OS Producer: " + os.getProducer());
        VersionNumber osVersion = os.getVersionNumber();
        log.info("OS version: " + osVersion.toVersionString());
        log.info("OS version major: " + osVersion.getMajor());
        log.info("OS version minor: " + osVersion.getMinor());
        log.info("OS version bug fix: " + osVersion.getBugfix());
        log.info("OS version extension: " + osVersion.getExtension());

        // device category
        ReadableDeviceCategory device = agent.getDeviceCategory();
        log.info("Device: " + device.getName());
        UserAgentInfo agentInfo = UserAgentInfo.builder()
                .browserName(agent.getName())
                .browserType(agent.getType().getName())
                .browserVersion(browserVersion.toVersionString())
                .deviceType(device.getName())
                .osType(os.getName())
                .osVersion(osVersion.toVersionString())
                .build();
        return agentInfo;
    }
}
