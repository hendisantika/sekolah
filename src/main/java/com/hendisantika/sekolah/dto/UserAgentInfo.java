package com.hendisantika.sekolah.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    @NotBlank
    private String userAgent;

    @NotEmpty
    @NotBlank
    private String osType;

    @NotEmpty
    @NotBlank
    private String osVersion;

    @NotEmpty
    @NotBlank
    private String browserName;

    @NotEmpty
    @NotBlank
    private String browserType;

    @NotEmpty
    @NotBlank
    private String browserVersion;

    @NotEmpty
    @NotBlank
    private String deviceType;

    @NotEmpty
    @NotBlank
    private String hostAddress;

    @NotEmpty
    @NotBlank
    private String hostName;
}
