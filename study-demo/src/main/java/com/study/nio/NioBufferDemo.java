package com.study.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class NioBufferDemo {
    public static void main(String[] args) {
        xx();

    }

    public static void xx() {
        CharBuffer buffer = CharBuffer.allocate(20);
        System.out.println("1-buffer.position:" + buffer.position() + "..buffer.limit:" + buffer.limit());
        buffer.put("需要输入好几个汉字");
        System.out.println("2-buffer.position:" + buffer.position() + "..buffer.limit:" + buffer.limit());
        buffer.position(0);
        printBuffer(buffer);
        System.out.println("3-buffer.position:" + buffer.position() + "..buffer.limit:" + buffer.limit());
        buffer.clear();
        System.out.println("4-buffer.position:" + buffer.position() + "..buffer.limit:" + buffer.limit());
        buffer.put("再输入几个汉子");
        System.out.println("5-buffer.position:" + buffer.position() + "..buffer.limit:" + buffer.limit());
        buffer.limit(buffer.position());
        buffer.position(0);
        System.out.println("6-buffer.position:" + buffer.position() + "..buffer.limit:" + buffer.limit());
        printBuffer(buffer);
    }

    public static void printBuffer(CharBuffer buffer) {
        System.out.println();

        for (int i = 0; i < buffer.limit(); i++) {
            System.out.print(buffer.get());
        }
        System.out.println();

    }

    /**
     * 缓冲区反转
     * 向缓冲区存储数据
     * 从缓冲区读取数据
     */
    public static void cacheAreaFlip() {
        ByteBuffer buffer = newByteBuffer();
        buffer.position(2);
        buffer.mark();
        buffer.flip();
        System.out.println("buffer.position():" + buffer.position());
        System.out.println("buffer.limit():" + buffer.limit());
        buffer.reset();
    }

    /**
     * 还原缓冲区的状态
     */
    public static void cacheAreaClear() {
        ByteBuffer buffer = newByteBuffer();
        buffer.position(2);
        buffer.limit(3);
        buffer.mark();
        buffer.clear();
        System.out.println("buffer.position():" + buffer.position());
        System.out.println("buffer.limit():" + buffer.limit());
        buffer.reset();
    }

    public static ByteBuffer newByteBuffer() {
        byte[] byteArray = new byte[]{1, 2, 3};
        ByteBuffer buffer = ByteBuffer.wrap(byteArray);
        return buffer;
    }
}
