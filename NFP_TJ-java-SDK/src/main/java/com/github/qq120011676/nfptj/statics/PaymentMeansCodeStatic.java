package com.github.qq120011676.nfptj.statics;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

import java.util.*;

/**
 * 付款方式代码
 */
public class PaymentMeansCodeStatic {
    private static final Map<String, String> DATA_MAP;

    static {
        List<String> lines = FileUtil.readUtf8Lines(Objects.requireNonNull(CountrySubdivisionCodeStatic.class.getResource("/payment_means_code.txt")));
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
            map.put(code, name);
        }
        DATA_MAP = Collections.unmodifiableMap(map);
    }


    public static PaymentMeansCodeStatic.Data parseCode(String code) {
        String name = DATA_MAP.get(code);
        if (StrUtil.isBlank(name)) {
            return null;
        }
        return new PaymentMeansCodeStatic.Data(code, name);
    }

    public static PaymentMeansCodeStatic.Data parseName(String name) {
        Set<Map.Entry<String, String>> entrySet = DATA_MAP.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            String dataName = entry.getValue();
            if (Objects.equals(dataName, name)) {
                return new PaymentMeansCodeStatic.Data(entry.getKey(), dataName);
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
