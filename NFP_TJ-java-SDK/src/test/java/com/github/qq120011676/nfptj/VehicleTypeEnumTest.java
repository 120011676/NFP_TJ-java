package com.github.qq120011676.nfptj;

import com.github.qq120011676.nfptj.enums.VehicleTypeEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class VehicleTypeEnumTest {
    public static void main(String[] args) {
        VehicleTypeEnum[] vehicleTypeEnums = VehicleTypeEnum.values();
        Map<String, String> valueMap = new HashMap<>();
        Map<String, String> nameMap = new HashMap<>();
        for (VehicleTypeEnum vehicleTypeEnum : vehicleTypeEnums) {
            String v = vehicleTypeEnum.getValue();
            if (valueMap.containsKey(v)) {
                throw new RuntimeException("value:【" + v + "】重复");
            }
            valueMap.put(v, null);
            String[] ns = vehicleTypeEnum.getNames();
            for (String n : ns) {
                if (nameMap.containsKey(n)) {
                    throw new RuntimeException("name:【" + n + "】重复");
                }
                nameMap.put(n, null);
            }
        }
        System.out.println(Objects.equals("H13", Optional.ofNullable(VehicleTypeEnum.parse("重型封闭式货车")).map(VehicleTypeEnum::getValue).orElse(null)));
        System.out.println(Objects.equals("H13", Optional.ofNullable(VehicleTypeEnum.parse("重型封闭货车")).map(VehicleTypeEnum::getValue).orElse(null)));
        System.out.println(Objects.equals("H14", Optional.ofNullable(VehicleTypeEnum.parse("重型罐式货车")).map(VehicleTypeEnum::getValue).orElse(null)));
        System.out.println(Objects.equals("H14", Optional.ofNullable(VehicleTypeEnum.parse("H14")).map(VehicleTypeEnum::getValue).orElse(null)));
    }
}
