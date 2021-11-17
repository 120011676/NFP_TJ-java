package com.github.qq120011676.nfptj;

import cn.hutool.core.io.FileUtil;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class CityCodeTest {
    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtil.readUtf8Lines(Objects.requireNonNull(CityCodeTest.class.getResource("/city_code_data.txt")));
        StringBuilder newContent = new StringBuilder();
        String code = null;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (Objects.equals("", line)) {
                continue;
            }
            if (code == null) {
                code = line;
                continue;
            }
            newContent.append(code).append("=").append(line).append("\n");
            code = null;
        }
        String path = Objects.requireNonNull(CityCodeTest.class.getResource("/")).getPath() + "city_code.txt";
        System.out.println(path);
        FileUtil.writeUtf8String(newContent.toString().trim(), path);
    }
}
