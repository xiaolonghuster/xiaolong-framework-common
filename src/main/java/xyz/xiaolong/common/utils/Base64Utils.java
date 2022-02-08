package xyz.xiaolong.common.utils;

import org.apache.commons.codec.binary.Base64;

/**
 * @Author lixiaolong
 * created by xlli5 on 2019/4/9 9:54 AM use IntelliJ IDEA
 */
public class Base64Utils {

    public Base64Utils() {
    }

    public static byte[] base64Encoding(byte[] pArray) {
        return base64Encoding(pArray, false);
    }

    public static byte[] base64Decoding(byte[] pArray) {
        return base64Decoding(pArray, false);
    }

    public static byte[] base64Encoding(byte[] pArray, boolean urlsafe) {
        return (new Base64(0, (byte[])null, urlsafe)).encode(pArray);
    }

    public static byte[] base64Decoding(byte[] pArray, boolean urlsafe) {
        return (new Base64(0, (byte[])null, urlsafe)).decode(pArray);
    }
}
