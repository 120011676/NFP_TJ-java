package com.github.qq120011676.nfptj;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class JSONTest {
    public static void main(String[] args) {
        System.out.println(JSONUtil.createObj()
                .append("userId", "1")
                .append("password", DigestUtil.md5Hex("233"))
                .toStringPretty());
        System.out.println(new JSONObject()
                .set("userId", "1")
                .set("password", DigestUtil.md5Hex("233"))
                .toStringPretty());
    }
}
