package com.example;

import java.io.*;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class Test {
    public static void main(String[] args) {
        String a = "[120, -38, -85, 86, 74, 44, 40, -56, -55, 76, 78, 44, -55, -52, -49, -13, 76, 81, -78, 50, -73, -80, 48, 50, -73, -80, 52, 49, 54, 49, 52, 51, 54, -46, 65, -106, 14, 46, 73, 44, 41, 45, 86, -78, 50, -60, 38, -20, -105, -104, -101, -86, 100, -91, -12, 116, 95, -21, -117, -123, 75, -97, -74, -74, 62, -35, -33, -6, 116, 73, -5, -109, -3, 11, -97, 53, -82, 87, -46, 81, 74, -53, -55, 47, -121, -23, 55, -42, 81, 42, 46, -55, 47, 74, 117, -50, 72, -52, -53, 75, -51, 81, -78, 50, -47, 81, 74, -50, -49, 43, 46, -51, -51, -52, 75, 119, 73, 44, 73, 13, -55, 4, -101, 101, 104, -14, 116, -55, 74, -93, -89, 27, -6, -97, 77, -33, -90, 84, 11, 0, 109, 70, 67, -17]";
    }

    private static String unzipString(String encodeString){
        String[] split = encodeString.split(",");
        byte[] copy= new byte[split.length];
        for (int i = 0; i < split.length; i++) {
            String s = split[i].trim();
            copy[i] = Byte.parseByte(s);
        }
        return unzipString(copy);
    }


    public static String unzipString(byte[] decode) {
        //创建一个新的解压缩器  https://www.yiibai.com/javazip/javazip_inflater.html

        Inflater inflater = new Inflater();
        //设置解压缩的输入数据。
        inflater.setInput(decode);
        final byte[] bytes = new byte[256];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(256);
        try {
            //finished() 如果已到达压缩数据流的末尾，则返回true。
            while (!inflater.finished()) {
                //将字节解压缩到指定的缓冲区中。
                int length = inflater.inflate(bytes);
                outputStream.write(bytes, 0, length);
            }
        } catch (DataFormatException e) {
            e.printStackTrace();
            return null;
        } finally {
            //关闭解压缩器并丢弃任何未处理的输入。
            inflater.end();
        }

        return outputStream.toString();
    }
}
