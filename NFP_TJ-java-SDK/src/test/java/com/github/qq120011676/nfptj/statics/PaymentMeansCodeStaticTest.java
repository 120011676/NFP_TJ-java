package com.github.qq120011676.nfptj.statics;

import java.util.Objects;

public class PaymentMeansCodeStaticTest {
    public static void main(String[] args) {
        System.out.println(Objects.equals("微信支付", Objects.requireNonNull(PaymentMeansCodeStatic.parseCode("42")).getName()));
        System.out.println(Objects.equals("42", Objects.requireNonNull(PaymentMeansCodeStatic.parseName("微信支付")).getCode()));

    }
}
