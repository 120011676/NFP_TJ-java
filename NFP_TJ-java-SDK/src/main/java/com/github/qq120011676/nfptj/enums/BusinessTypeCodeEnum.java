package com.github.qq120011676.nfptj.enums;

import java.util.Objects;

/**
 * 业务类型代码
 */
public enum BusinessTypeCodeEnum {
    TRUNK_GENERAL_CARGO_TRANSPORTATION("1002996", "干线普货运输"),//干线普货运输服务
    URBAN_DISTRIBUTION("1003997", "城市配送"),//在城市范围内进行配送
    RURAL_DISTRIBUTION("1003998", "农村配送"),//若发货方或收货方在农村地区即为农村物流
    CONTAINER_TRANSPORT("1002998", "集装箱运输"),//集装箱运输
    OTHER("1003999", "其他"),//其他
    ;
    private final String value;
    private final String name;

    BusinessTypeCodeEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static BusinessTypeCodeEnum parse(String nameOrValue) {
        BusinessTypeCodeEnum[] enums = values();
        for (BusinessTypeCodeEnum en : enums) {
            if (Objects.equals(en.getValue(), nameOrValue) || Objects.equals(en.getName(), nameOrValue)) {
                return en;
            }
        }
        return null;
    }
}
