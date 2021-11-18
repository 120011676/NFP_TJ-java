package com.github.qq120011676.nfptj.enums;

import java.util.Objects;

/**
 * 运输组织类型代码
 */
public enum TransportTypeCodeEnum {
    HIGHWAY(1, "公路运输"),
    HIGHWAY_RAILWAY(2, "公铁联运"),
    HIGHWAY_WATERWAY(3, "公水联运"),
    HIGHWAY_AVIATION(4, "公空联运"),
    HIGHWAY_RAILWAY_WATERWAY(5, "公铁水联运"),
    HIGHWAY_RAILWAY_AVIATION(6, "公铁空联运"),
    HIGHWAY_WATERWAY_AVIATION(7, "公水空联运"),
    HIGHWAY_RAILWAY_WATERWAY_AVIATION(8, "公铁水空联运"),
    ;
    private final int value;
    private final String name;

    TransportTypeCodeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static TransportTypeCodeEnum parse(String nameOrValue) {
        TransportTypeCodeEnum[] enums = values();
        for (TransportTypeCodeEnum en : enums) {
            if (Objects.equals(en.getValue() + "", nameOrValue) || Objects.equals(en.getName(), nameOrValue)) {
                return en;
            }
        }
        return null;
    }

    public static TransportTypeCodeEnum parse(int value) {
        TransportTypeCodeEnum[] enums = values();
        for (TransportTypeCodeEnum en : enums) {
            if (Objects.equals(en.getValue(), value)) {
                return en;
            }
        }
        return null;
    }
}
