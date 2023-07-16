package top.hanlinqi.core.serializer;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: SerialManager
 * @description: 序列化管理机制
 * @author: hanLinQi
 * @create: 2023-02-28 10:51
 **/

public class SerializerManager {

    private final static ConcurrentHashMap<Byte, ISerializer> map = new ConcurrentHashMap<>();

    static {
        ISerializer javaSerial = new JavaSerializer();
        ISerializer jsonSerial = new JsonSerializer();
        map.put(javaSerial.getSerializerType(), javaSerial);
        map.put(jsonSerial.getSerializerType(), jsonSerial);
    }

    public static ISerializer getSerializer(byte key) {
        ISerializer serializer = map.get(key);
        // 默认采用Java序列化
        if (serializer == null) {
            return new JavaSerializer();
        }
        return serializer;
    }
}
