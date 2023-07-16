package top.hanlinqi.core.serializer;

import com.alibaba.fastjson.JSON;
import top.hanlinqi.core.enums.SerializerType;

/**
 * @program: JsonSerializer
 * @description: Json序列化
 * @author: hanLinQi
 * @create: 2023-03-08 09:49
 **/

public class JsonSerializer implements ISerializer {

    @Override
    public <T> byte[] serializer(T t) {
        return JSON.toJSONBytes(t);
    }

    @Override
    public <T> T deSerializer(byte[] data, Class<T> tClass) {
        return JSON.parseObject(new String(data), tClass);
    }

    @Override
    public byte getSerializerType() {
        return SerializerType.JSON_SERIAL.code();
    }
}
