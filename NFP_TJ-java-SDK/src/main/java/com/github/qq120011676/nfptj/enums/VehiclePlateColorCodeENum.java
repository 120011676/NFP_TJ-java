package com.github.qq120011676.nfptj.enums;

/**
 * 车牌颜色代码
 */
public enum VehiclePlateColorCodeENum {
    BLUE("1", "蓝色"),
    YELLOW("2", "黄色"),
    BLACK("3", "黑色"),
    WHITE("4", "白色"),
    GREEN("5", "绿色"),
    OTHER("9", "其他"),
    AGRICULTURAL_YELLOW("91", "农黄色"),
    AGRICULTURAL_GREEN("92", "农绿色"),
    YELLOW_GREEN("93", "黄绿色"),
    GRADIENT_GREEN("94", "渐变绿");

    private final String value;
    private final String name;

    VehiclePlateColorCodeENum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
