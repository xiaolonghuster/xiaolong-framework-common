package xyz.xiaolong.common.utils;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @Author lixiaolong
 * created by xlli5 on 2019/4/9 9:53 AM use IntelliJ IDEA
 */
public class DESUtils {

    private static final String ALGORITHM_STR = "DES/ECB/PKCS5Padding";

    public DESUtils() {
    }

    public static byte[] encrypt(byte[] expresslyBytes, byte[] rawKey) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException {
        DESKeySpec dkSpec = new DESKeySpec(rawKey);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dkSpec);
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(1, key);
        return cipher.doFinal(expresslyBytes);
    }

    public static byte[] dencrypt(byte[] ciphertextBytes, byte[] rawKey) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException {
        DESKeySpec dkSpec = new DESKeySpec(rawKey);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dkSpec);
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(2, key);
        return cipher.doFinal(ciphertextBytes);
    }

    public static String encryptUrl(String expresslyText, String key, String charset) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, UnsupportedEncodingException {
        byte[] data = encrypt(expresslyText.getBytes(charset), key.getBytes(charset));
        String text = new String(Base64Utils.base64Encoding(data, true));
        return text;
    }

    public static String dencryptUrl(String cipherText, String key, String charset) throws UnsupportedEncodingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException {
        byte[] data = Base64Utils.base64Decoding(cipherText.getBytes(charset), true);
        data = dencrypt(data, key.getBytes(charset));
        return new String(data, charset);
    }

    public static String encryptUrl(String expresslyText, String key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, UnsupportedEncodingException {
        return encryptUrl(expresslyText, key, "UTF-8");
    }

    public static String dencryptUrl(String cipherText, String key) throws UnsupportedEncodingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException {
        return dencryptUrl(cipherText, key, "UTF-8");
    }
}
