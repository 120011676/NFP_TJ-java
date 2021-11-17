package com.github.qq120011676.nfptj.enums;

import java.util.Objects;

/**
 * 车辆能源类型
 */
public enum VehicleEnergyEnum {
    A("A", "汽油"),
    B("B", "柴油"),
    C("C", "电"),//以电能驱动的汽车
    D("D", "混合油"),
    E("E", "天然气"),
    F("F", "液化石油气"),
    L("L", "甲醇"),
    M("M", "乙醇"),
    N("N", "太阳能"),
    O("O", "混合动力"),
    Y("Y", "无"),//仅限全挂车等无动力的
    Z("Z", "其他"),
    ;
    private final String value;
    private final String name;

    VehicleEnergyEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static VehicleEnergyEnum parse(String nameOrValue) {
        VehicleEnergyEnum[] vehicleEnergyEnums = values();
        for (VehicleEnergyEnum vehicleEnergyEnum : vehicleEnergyEnums) {
            if (Objects.equals(vehicleEnergyEnum.getValue(), nameOrValue) || Objects.equals(vehicleEnergyEnum.getName(), nameOrValue)) {
                return vehicleEnergyEnum;
            }
        }
        return null;
    }
}
