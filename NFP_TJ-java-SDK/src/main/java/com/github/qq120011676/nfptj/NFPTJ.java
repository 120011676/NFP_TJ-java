package com.github.qq120011676.nfptj;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.text.MessageFormat;

public class NFPTJ {
    private final String userId;
    private final String password;
    private final String baseUrl;
    private static final String USER_AGENT = "NFP_TJ-java-SDK";
    private static final String AUTHOR = "Say.li <120011676@qq.com>";
    private static final String HTTP_HEADER_AUTHOR = "Author";

    public NFPTJ(String userId, String password) {
        this(userId, password, null);
    }

    public NFPTJ(String userId, String password, String baseUrl) {
        this.userId = userId;
        this.password = password;
        if (StrUtil.isBlank(baseUrl)) {
            baseUrl = "http://218.67.246.252:7999";
        }
        this.baseUrl = baseUrl;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * 申请令牌接口
     *
     * @return 令牌
     */
    public String applyToken() {
        return applyToken(userId, password);
    }

    /**
     * 申请令牌接口
     *
     * @param userId   物流交换代码
     * @param password 密码
     * @return 令牌
     */
    public String applyToken(String userId, String password) {
        String json = post("/auth/applyToken", JSONUtil.createObj()
                .set("userId", userId)
                .set("password", DigestUtil.md5Hex(password))
                .toString());
        JSONObject jsonObject = JSONUtil.parseObj(json);
        if (!"00000".equals(jsonObject.getStr("code"))) {
            throw new RuntimeException(json);
        }
        return jsonObject.getStr("token");
    }

    private String send() {
        return null;
    }

    private String post(String uri, String body) {
        return HttpUtil.createPost(MessageFormat.format("{0}{1}", baseUrl, uri))
                .header(Header.USER_AGENT, USER_AGENT)
                .header(HTTP_HEADER_AUTHOR, AUTHOR)
                .body(body)
                .execute()
                .body();
    }
}
