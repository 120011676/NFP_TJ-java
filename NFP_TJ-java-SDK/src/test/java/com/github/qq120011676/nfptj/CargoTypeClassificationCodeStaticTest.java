package com.github.qq120011676.nfptj;

import com.github.qq120011676.nfptj.statics.CargoTypeClassificationCodeStatic;

import java.util.Objects;

public class CargoTypeClassificationCodeStaticTest {
    public static void main(String[] args) {
        System.out.println(Objects.equals("金属矿石", Objects.requireNonNull(CargoTypeClassificationCodeStatic.parseCode("0300")).getName()));
        System.out.println(Objects.equals("0300", Objects.requireNonNull(CargoTypeClassificationCodeStatic.parseName("金属矿石")).getCode()));
    }
}
