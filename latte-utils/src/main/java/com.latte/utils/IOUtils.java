package com.latte.utils;

import java.io.*;

public class IOUtils {
    public static String readFile(String path) throws IOException {

        /**
         * 不需要finally保证流正确关闭
         * 使用try语句管理的资源需java类满足实现java.lang.AutoClosable接口-出现编译异常
         * 自动调用close方法
         * eg I/O java.io.Closeable
         * eg sql java.sql.Connection,java.sql.ResultSet java.sql.Statement
         * diy 继承AutoClosable接口 {@link ResourceReleaseDemo}
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(String.format("%n"));
            }
            return builder.toString();
        }
    }

    public static void jdk9_feature() {
        InputStreamReader reader = new InputStreamReader(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        try (reader; writer) {
            //reader是final的，不可再被赋值
            //reader = null;
            //具体读写操作省略
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
