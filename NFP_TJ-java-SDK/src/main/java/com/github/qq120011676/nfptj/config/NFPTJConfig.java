package com.github.qq120011676.nfptj.config;

import lombok.Data;

import java.time.Duration;

@Data
public class NFPTJConfig {
    /**
     * 物流交换代码 必须
     */
    private String userId;

    /**
     * 密码 必须
     */
    private String password;

    /**
     * 请求地址 必须
     */
    private String baseUrl = "http://218.67.246.252:7999";

    /**
     * 公钥 必须
     */
    private String publicKey;

    /**
     * 超时时间（连接+读取）（默认10秒）单位毫秒
     */
    private Duration timeout = Duration.ofSeconds(10);

    /**
     * 网络货运经营者名称，
     * 运单同步需要，配置后运单可不传自动设置
     */
    private String carrier;

    /**
     * 统一社会信用代码，
     * 运单同步需要，配置后运单可不传自动设置
     */
    private String unifiedSocialCreditIdentifier;

    /**
     * 道路运输经营许可证编号（网络货运经营者的道路运输经营许可证编号。）
     * 运单同步需要，配置后运单可不传自动设置
     */
    private String permitNumber;
}
