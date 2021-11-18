package com.github.qq120011676.nfptj.statics;

import java.util.Objects;

public class BankCodeStaticTest {
    public static void main(String[] args) {
        System.out.println(Objects.equals("徐州农村商业银行", Objects.requireNonNull(BankCodeStatic.parseCode("XZCB")).getName()));
        System.out.println(Objects.equals("XZCB", Objects.requireNonNull(BankCodeStatic.parseName("徐州农村商业银行")).getCode()));
    }
}
