package com.github.qq120011676.nfptj;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.github.qq120011676.nfptj.ro.DriverRO;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class NFPTJ {
    private final String userId;
    private final String password;
    private final String baseUrl;
    private final String publicKey;
    private static final String USER_AGENT = "NFP_TJ-java-SDK";
    private static final String AUTHOR = "Say.li <120011676@qq.com>";
    private static final String HTTP_HEADER_AUTHOR = "Author";
    private volatile String token;

    public NFPTJ(String userId, String password, String publicKey) {
        this(userId, password, publicKey, null);
    }

    public NFPTJ(String userId, String password, String publicKey, String baseUrl) {
        this.userId = userId;
        this.password = password;
        this.publicKey = publicKey;
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

    public String getPublicKey() {
        return publicKey;
    }

    public String getToken() {
        return token;
    }

    {
        token();
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
    protected String applyToken(String userId, String password) {
        String json = post("/auth/applyToken", JSONUtil.createObj()
                .set("userId", userId)
                .set("password", DigestUtil.md5Hex(password))
                .toString());
        System.out.println(json);
        JSONObject jsonObject = JSONUtil.parseObj(json);
        if (!"00000".equals(jsonObject.getStr("code"))) {
            throw new RuntimeException(json);
        }
        return jsonObject.getStr("token");
    }

    public boolean driver(DriverRO ro) {
        return driver(ro, null);
    }

    /**
     * 驾驶员信息 上报
     *
     * @param ro        驾驶员信息对象
     * @param messageId 消息id
     * @return true成功，false失败
     */
    public boolean driver(DriverRO ro, String messageId) {
        if (StrUtil.isBlank(messageId)) {
            messageId = UUID.randomUUID().toString().replaceAll("-", "");
        }
        return send("WLHY_JSY1001", "驾驶员信息单", messageId, null);
    }

    /**
     * 上报接口。
     *
     * @param ipcType                业务接口代码 an..16 必填
     * @param documentName           报文名称 an..35 必填，报文中文名称:电子运单、资金流水单、车辆信息单、驾驶员信息单
     * @param content                内容 an..8192 必填
     * @param messageReferenceNumber 报文参考号 an..35 必填，报文的唯一标识符，由系统按 GUID 规则自动产生。
     * @return true成功，false失败
     */
    protected boolean send(String ipcType, String documentName, String content, String messageReferenceNumber) {
        return send(ipcType, documentName, content, messageReferenceNumber, DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now()), userId, getToken());
    }

    /**
     * 上报接口。
     *
     * @param ipcType                业务接口代码 an..16 必填
     * @param documentName           报文名称 an..35 必填，报文中文名称:电子运单、资金流水单、车辆信息单、驾驶员信息单
     * @param content                内容 an..8192 必填
     * @param messageReferenceNumber 报文参考号 an..35 必填，报文的唯一标识符，由系统按 GUID 规则自动产生。
     * @param messageSendingDateTime 发送日期时间 n14 必填，报文发送的日期时间， YYYYMMDDhhmmss。
     * @param userId                 物流交换代码 an..35 必填，系统接入分配的交换代码
     * @param token                  令牌 an..32 必填，接入系统申请的令牌
     * @return true成功，false失败
     */
    protected boolean send(String ipcType, String documentName, String content, String messageReferenceNumber, String messageSendingDateTime, String userId, String token) {
        String json = post("/wlhy/send", JSONUtil.createObj()
                .set("IPCType", ipcType)
                .set("DocumentName", documentName)
                .set("EncryptedContent", SmUtil.sm2(null, publicKey).encryptBase64(content, KeyType.PublicKey))
                .set("MessageReferenceNumber", messageReferenceNumber)
                .set("MessageSendingDateTime", messageSendingDateTime)
                .set("UserId", userId)
                .set("Token", token)
                .toString());
        JSONObject jsonObject = JSONUtil.parseObj(json);
        String code = jsonObject.getStr("code");
        if ("20000".equals(code)) {
            return send(ipcType, documentName, content, messageReferenceNumber, messageSendingDateTime, userId, reToken());
        } else if (!"00000".equals(code)) {
            throw new RuntimeException(json);
        }
        return true;
    }

    protected String token() {
        if (StrUtil.isBlank(token)) {
            reToken();
        }
        if (StrUtil.isBlank(token)) {
            throw new RuntimeException("获取token失败");
        }
        return token;
    }

    protected String reToken() {
        token = applyToken();
        return token;
    }

    protected String post(String uri, String body) {
        return HttpUtil.createPost(MessageFormat.format("{0}{1}", baseUrl, uri))
                .header(Header.USER_AGENT, USER_AGENT)
                .header(HTTP_HEADER_AUTHOR, AUTHOR)
                .body(body)
                .execute()
                .body();
    }
}
