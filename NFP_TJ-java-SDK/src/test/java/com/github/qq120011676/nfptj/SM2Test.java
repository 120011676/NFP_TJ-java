package com.github.qq120011676.nfptj;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;

public class SM2Test {
    public static void main(String[] args) {
        String content = "abc";
        String publicKey = "3059301306072a8648ce3d020106082a811ccf5501822d03420004f228e9d80fe12e628d9e8106d9a6c236eaa63d00ae47888bc3217ceb7002953cd458eccbdc6f75aacb9c21e84689b6b0b9b2d79b9c96efeba5dca2e9998873ce";
        String r = SmUtil.sm2(null, publicKey).encryptBase64(content, KeyType.PublicKey);
        System.out.println(r);
    }
}
