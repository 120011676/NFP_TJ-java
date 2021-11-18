package com.github.qq120011676.nfptj.statics;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

import java.util.*;

public class CountrySubdivisionCodeStatic {
    private static final Map<String, String> CITY_CODE_MAP;

    static {
        List<String> lines = FileUtil.readUtf8Lines(Objects.requireNonNull(CountrySubdivisionCodeStatic.class.getResource("/city_code.txt")));
        Map<String, String> map = new HashMap<>(lines.size());
        for (String line : lines) {
            if (Objects.equals("", line.trim())) {
                continue;
            }
            String[] tmp = line.split("=");
            if (tmp.length < 2) {
                continue;
            }
            String code = tmp[0].trim();
            String name = tmp[1].trim();
            if (StrUtil.isBlank(code) || StrUtil.isBlank(name)) {
                continue;
            }
            map.put(code, name);
        }
        CITY_CODE_MAP = Collections.unmodifiableMap(map);
    }

    public static Data parseCode(String code) {
        String name = CITY_CODE_MAP.get(code);
        if (StrUtil.isBlank(name)) {
            return null;
        }
        return new Data(code, name);
    }

    public static Data parseName(String name) {
        Set<Map.Entry<String, String>> entrySet = CITY_CODE_MAP.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            if (entry.getValue().startsWith(name)) {
                return new Data(entry.getKey(), entry.getValue());
            }
        }
        return null;
    }

    public static class Data {
        private final String code;
        private final String name;

        public Data(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
