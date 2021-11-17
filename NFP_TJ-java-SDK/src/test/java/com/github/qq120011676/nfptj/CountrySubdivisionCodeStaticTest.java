package com.github.qq120011676.nfptj;

import com.github.qq120011676.nfptj.statics.CountrySubdivisionCodeStatic;

import java.util.Objects;

public class CountrySubdivisionCodeStaticTest {
    public static void main(String[] args) {
        System.out.println(Objects.equals("北京城区", Objects.requireNonNull(CountrySubdivisionCodeStatic.parseCode("110100")).getName()));
        System.out.println(Objects.equals("东城区", Objects.requireNonNull(CountrySubdivisionCodeStatic.parseName("东城区")).getName()));
        System.out.println(Objects.requireNonNull(CountrySubdivisionCodeStatic.parseName("四川")).getName());
        System.out.println(Objects.equals("四川省", Objects.requireNonNull(CountrySubdivisionCodeStatic.parseName("四川")).getName()));

    }
}
