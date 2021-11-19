package com.github.qq120011676.nfptj.statics;

import java.util.Objects;

public class InsuranceCompanyCodeStaticTest {
    public static void main(String[] args) {
        System.out.println(Objects.equals("中国大地财产保险股份有限公司", Objects.requireNonNull(InsuranceCompanyCodeStatic.parseCode("CCIC")).getName()));
        System.out.println(Objects.equals("CCIC", Objects.requireNonNull(InsuranceCompanyCodeStatic.parseName("中国大地财产保险股份有限公司")).getCode()));
    }
}
