package com.example.util;

import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/**
 * @author zhaodaming
 * @description:
 * @date 10/26/21
 */
public class JsonParseUtil {

    public static String unzipString(String encodeString) throws DataFormatException {
        String str = encodeString.replace("[", "").replace("]", "");
        String[] split = str.split(",");
        byte[] copy= new byte[split.length];
        for (int i = 0; i < split.length; i++) {
            String s = split[i].trim();
            copy[i] = Byte.parseByte(s);
        }
        return unzipString(copy);
    }

    private static String unzipString(byte[] decode) throws DataFormatException {
        //创建一个新的解压缩器  https://www.yiibai.com/javazip/javazip_inflater.html

        Inflater inflater = new Inflater();
        //设置解压缩的输入数据。
        inflater.setInput(decode);
        final byte[] bytes = new byte[8192];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(8192);
        try {
            //finished() 如果已到达压缩数据流的末尾，则返回true。
            int length = 1;
            while (!inflater.finished() && length != 0) {
                //将字节解压缩到指定的缓冲区中。
                length = inflater.inflate(bytes);
                outputStream.write(bytes, 0, length);
            }
        } finally {
            //关闭解压缩器并丢弃任何未处理的输入。
            inflater.end();
        }

        return outputStream.toString();
    }
}
