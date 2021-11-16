package com.github.qq120011676.nfptj.enums;

/**
 * 营运车辆类型代码
 */
public enum VehicleTypeEnum {
    H11("H11", new String[]{"重型普通货车", "重型栏板货车"}),
    H12("H12", new String[]{"重型厢式货车"}),
    H13("H13", new String[]{"重型封闭货车", "重型封闭式货车"}),
    H14("H14", new String[]{"重型罐式货车"}),
    H15("H15", new String[]{"重型平板货车"}),
    H16("H16", new String[]{"重型集装厢车", "重型集装箱车"}),
    H17("H17", new String[]{"重型自卸货车"}),
    H18("H18", new String[]{"重型特殊结构货车"}),
    H19("H19", new String[]{"重型仓栅式货车"}),
    H21("H21", new String[]{"中型普通货车", "中型栏板货车"}),
    H22("H22", new String[]{"中型厢式货车"}),
    H23("H23", new String[]{"中型封闭货车", "中型封闭式货车"}),
    H24("H24", new String[]{"中型罐式货车"}),
    H25("H25", new String[]{"中型平板货车"}),
    H26("H23", new String[]{"中型集装厢车", "中型集装箱车"}),
    H27("H27", new String[]{"中型自卸货车"}),
    H28("H28", new String[]{"中型特殊结构货车"}),
    H29("H29", new String[]{"中型仓栅式货车"}),
    H31("H31", new String[]{"轻型普通货车", "轻型栏板货车"}),
    H32("H32", new String[]{"轻型厢式货车"}),
    H33("H33", new String[]{"轻型封闭货车", "轻型封闭式货车"}),
    H34("H34", new String[]{"轻型罐式货车"}),
    H35("H35", new String[]{"轻型平板货车"}),
    H37("H37", new String[]{"轻型自卸货车"}),
    H38("H38", new String[]{"轻型特殊结构货车"}),
    H39("H39", new String[]{"轻型仓栅式货车"}),
    H41("H41", new String[]{"微型普通货车", "微型栏板货车"}),
    H42("H42", new String[]{"微型厢式货车"}),
    H43("H43", new String[]{"微型封闭货车", "微型封闭式货车"}),
    H44("H44", new String[]{"微型罐式货车"}),
    H45("H45", new String[]{"微型自卸货车"}),
    H46("H46", new String[]{"微型特殊结构货车"}),
    H47("H47", new String[]{"微型仓栅式货车"}),
    H51("H51", new String[]{"普通低速货车", "栏板低速货车"}),
    H52("H52", new String[]{"厢式低速货车"}),
    H53("H53", new String[]{"罐式低速货车"}),
    H54("H54", new String[]{"自卸低速货车"}),
    H55("H55", new String[]{"仓栅式低速货车"}),
    Q11("Q11", new String[]{"重型半挂牵引车"}),


    Z72("Z72", new String[]{"轻型载货专项作业车"});

    private final String value;
    private final String[] names;

    VehicleTypeEnum(String value, String[] names) {
        this.value = value;
        this.names = names;
    }

    public String getValue() {
        return value;
    }

    public String[] getNames() {
        return names;
    }
}
