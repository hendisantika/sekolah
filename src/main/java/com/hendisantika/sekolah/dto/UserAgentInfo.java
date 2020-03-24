package com.hendisantika.sekolah.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/03/20
 * Time: 06.44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAgentInfo {
    private String userAgent;
    private String osType;
    private String osVersion;
    private String browserName;
    private String browserType;
    private String browserVersion;
    private String deviceType;
}
