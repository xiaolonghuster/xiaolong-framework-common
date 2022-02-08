package xyz.xiaolong.common.logging;

import java.util.Random;

/**
 * @Author lixiaolong
 * created by xlli5 on 2019/4/15 3:50 PM use IntelliJ IDEA
 */
public class RandomNumber {
    private static Random random = new Random();

    private RandomNumber() {
    }

    public static String getRandomNumString(int length) {
        StringBuffer ret = new StringBuffer();

        for(int i = 0; i < length; ++i) {
            ret.append(Integer.valueOf(Math.abs(random.nextInt() % 10)).toString());
        }

        return ret.toString();
    }
}
