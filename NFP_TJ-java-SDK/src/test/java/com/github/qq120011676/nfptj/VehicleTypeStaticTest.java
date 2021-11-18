package com.github.qq120011676.nfptj;

import com.github.qq120011676.nfptj.statics.VehicleTypeStatic;

import java.util.Objects;

public class VehicleTypeStaticTest {
    public static void main(String[] args) {
        System.out.println(Objects.equals("重型封闭式货车", Objects.requireNonNull(VehicleTypeStatic.parseCode("H13")).getNames()[1]));
        System.out.println(Objects.equals("中型栏板货车", Objects.requireNonNull(VehicleTypeStatic.parseName("中型栏板货车")).getNames()[1]));

    }
}
