package com.github.qq120011676.nfptj.statics;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

import java.util.*;

/**
 * 营运车辆类型代码
 */
public class VehicleTypeStatic {
    private static final Map<String, String[]> DATA_MAP;

    static {
        List<String> lines = FileUtil.readUtf8Lines(Objects.requireNonNull(CountrySubdivisionCodeStatic.class.getResource("/vehicle_type.txt")));
        Map<String, String[]> map = new HashMap<>(lines.size());
        for (String line : lines) {
            if (Objects.equals("", line.trim())) {
                continue;
            }
            String[] tmp = line.split("=");
            if (tmp.length < 2) {
                continue;
            }
            String code = tmp[0].trim();
            String names = tmp[1].trim();
            if (StrUtil.isBlank(code) || StrUtil.isBlank(names)) {
                continue;
            }
            map.put(code, names.split(","));
        }
        DATA_MAP = Collections.unmodifiableMap(map);
    }


    public static VehicleTypeStatic.Data parseCode(String code) {
        String[] names = DATA_MAP.get(code);
        if (names == null) {
            return null;
        }
        return new VehicleTypeStatic.Data(code, names);
    }

    public static VehicleTypeStatic.Data parseName(String name) {
        Set<Map.Entry<String, String[]>> entrySet = DATA_MAP.entrySet();
        for (Map.Entry<String, String[]> entry : entrySet) {
            String[] names = entry.getValue();
            for (String ns : names) {
                if (Objects.equals(ns, name)) {
                    return new VehicleTypeStatic.Data(entry.getKey(), names);
                }
            }
        }
        return null;
    }

    public static class Data {

        private final String code;
        private final String[] names;

        public Data(String code, String... names) {
            this.code = code;
            this.names = names;
        }

        public String getCode() {
            return code;
        }

        public String[] getNames() {
            return names;
        }
    }
}
