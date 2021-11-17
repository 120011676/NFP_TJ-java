package com.github.qq120011676.nfptj.enums;

import java.util.Objects;

public enum CountrySubdivisionCodeEnum {
    ;
    private final String value;
    private final String name;

    CountrySubdivisionCodeEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static CountrySubdivisionCodeEnum parse(String nameOrValue) {
        CountrySubdivisionCodeEnum[] enums = values();
        for (CountrySubdivisionCodeEnum en : enums) {
            if (Objects.equals(en.getValue(), nameOrValue) || Objects.equals(en.getName(), nameOrValue)) {
                return en;
            }
        }
        return null;
    }
}
