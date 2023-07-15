package com.hendisantika.sekolah.dto;

import lombok.*;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/03/20
 * Time: 06.44
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAgentInfo {
    private String userAgent;
    private String osType;
    private String osVersion;
    private String browserName;
    private String browserType;
    private String browserVersion;
    private String deviceType;
    private String hostAddress;
    private String hostName;
}
