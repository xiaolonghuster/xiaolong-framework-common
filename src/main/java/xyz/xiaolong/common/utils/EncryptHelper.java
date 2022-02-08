package xyz.xiaolong.common.utils;

import xyz.xiaolong.common.ConstValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.MessageDigest;

/**
 * @Author lixiaolong
 * created by xlli5 on 2019/4/9 9:52 AM use IntelliJ IDEA
 */
public class EncryptHelper {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EncryptHelper.class);

    private EncryptHelper() {
    }

    /***
     * des加密
     *
     * @param expresslyBytes
     *            :明文
     * @param key
     *            ： 秘钥
     * @return
     */
    public static byte[] desEncrypt(byte[] expresslyBytes, byte[] key) {
        try {
            return DESUtils.encrypt(expresslyBytes, key);
        } catch (Exception e) {
            LOGGER.error(ConstValue.EXCEPTION_OCCURRED, e);
            return new byte[0];
        }
    }

    /***
     * des解密
     *
     * @param ciphertextBytes
     *            : 密文
     * @param key
     *            ：秘钥
     * @return
     */
    public static byte[] desDecrypt(byte[] ciphertextBytes, byte[] key) {
        try {
            return DESUtils.dencrypt(ciphertextBytes, key);
        } catch (Exception e) {
            LOGGER.error(ConstValue.EXCEPTION_OCCURRED, e);
            return new byte[0];
        }
    }

    /***
     * md5加密
     *
     * @param source
     *            : 明文
     * @return： md5加密后的密文
     */
    public static String encryptMD5(byte[] expresslyBytes) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            // 使用MD5创建MessageDigest对象
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(expresslyBytes);

            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;

            for (int i = 0; i < j; i++) {
                byte b = md[i];
                // 将没个数(int)b进行双字节加密
                str[k++] = hexDigits[b >> 4 & 0xf];
                str[k++] = hexDigits[b & 0xf];
            }

            return new String(str);

        } catch (Exception e) {
            LOGGER.error(ConstValue.EXCEPTION_OCCURRED, e);
            return null;
        }
    }

    public static Key getKey(byte[] b) {
        byte[] temp = new byte[8];
        for (int i = 0; i < temp.length && i < b.length; i++) {
            temp[i] = b[i];
        }
        return new SecretKeySpec(temp, "DES");
    }

    public static String byte2hex(byte[] b) {
        String temp;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            temp = Integer.toString(b[i] & 0xff, 16);
            if (temp.length() == 1) {
                temp = "0" + temp;
            }
            sb.append(temp);
        }
        return sb.toString();
    }

    /**
     * des解密(非向量)
     *
     * @param key
     * @param s
     * @return
     */
    public static String desEncrptNotIV(String key, String s) {
        try {
            Key key2 = getKey(key.getBytes());
            Cipher cen = Cipher.getInstance("DES");

            cen.init(Cipher.ENCRYPT_MODE, key2);
            byte[] enb = cen.doFinal(s.getBytes());

            return byte2hex(enb);
        } catch (Exception e) {
            LOGGER.error(ConstValue.EXCEPTION_OCCURRED, e);
            return null;
        }
    }

    /**
     * 执行异或运算
     * <p>
     *
     * @param source
     * @param keyPrefix
     * @return 异或后的byte[]
     * @author dsfan, 2013-12-13
     */
    public static byte[] excuteXorEncrypt(byte[] source, String keyPrefix) {
        String keyString = keyPrefix + source.length;
        byte[] keyBytes = keyString.getBytes(Charset.forName(ConstValue.UTF8));

        if (source.length < keyBytes.length) {
            return new byte[0];
        }

        for (int i = 0; i < keyBytes.length; i++) {
            source[i] = (byte) (source[i] ^ keyBytes[i]);
        }

        return source;
    }
}
