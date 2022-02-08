package xyz.xiaolong.common.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @Author lixiaolong
 * created by xlli5 on 2019/4/16 1:40 PM use IntelliJ IDEA
 */
public class MD5Utils {
    public MD5Utils() {
    }

    public static String md5Hex(byte[] plainText, boolean needShort, boolean uppercase) {
        String encrypted = DigestUtils.md5Hex(plainText);
        if (needShort) {
            encrypted = encrypted.substring(8, 24);
        }

        if (uppercase) {
            encrypted = encrypted.toUpperCase();
        }

        return encrypted;
    }

    public static String md5Hex(byte[] plainText) {
        return md5Hex(plainText, false, false);
    }

    public static String md5HexWithSalt(byte[] plainText, byte[] salt) {
        return md5Hex(ArrayUtils.addAll(plainText, salt));
    }
}
