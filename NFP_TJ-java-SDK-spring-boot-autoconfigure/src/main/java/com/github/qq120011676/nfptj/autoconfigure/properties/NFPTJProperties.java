package com.github.qq120011676.nfptj.autoconfigure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Data
@ConfigurationProperties(prefix = "nfp.tj")
public class NFPTJProperties {
    /**
     * 物流交换代码
     */
    private String userId;

    /**
     * 密码
     */
    private String password;

    /**
     * 请求地址
     */
    private String baseUrl = "http://218.67.246.252:7999";

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 超时时间（连接+读取）（默认10秒）单位毫秒
     */
    @DurationUnit(ChronoUnit.MILLIS)
    private Duration timeout = Duration.ofSeconds(10);

}
