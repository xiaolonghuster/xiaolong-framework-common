package xyz.xiaolong.common.utils;

import xyz.xiaolong.common.ConstValue;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lixiaolong
 * created by xlli5 on 2019/3/20 4:22 PM use IntelliJ IDEA
 */
public class XMLUtils {

    private static Map<String, JAXBContext> contextMap = new HashMap<>();

    public static String toXmlString(Object t, Class<?>... clazz) throws JAXBException {
        JAXBContext context = getContext(clazz);    // 获取上下文对象
        Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象

        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");  // 设置编码字符集
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        marshaller.marshal(t, outputStream);
        // 生成XML字符串
        return new String(outputStream.toByteArray());
    }

    public static <T> T parseXmlObject(String xml, Class<T>... clazz) throws JAXBException {
        JAXBContext context = getContext(clazz);    // 获取上下文对象
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        return (T) unmarshaller.unmarshal(inputStream);
    }

    private static JAXBContext getContext(Class<?>... clazz) throws JAXBException {
        String name = getClassName(clazz);
        JAXBContext context = contextMap.get(name);
        if (context == null) {
            context = JAXBContext.newInstance(clazz);
            contextMap.put(name, context);
        }
        return context;
    }

    private static String getClassName(Class<?>... clazz) {
        String name = null;
        if (clazz != null && clazz.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (Class claz : clazz) {
                sb.append(claz.getName()).append(ConstValue.PUNCTUATION_COMMA);
            }
            name = StringUtils.substring(sb.toString(), 0,sb.length() - 1);
        }
        return name;
    }
}