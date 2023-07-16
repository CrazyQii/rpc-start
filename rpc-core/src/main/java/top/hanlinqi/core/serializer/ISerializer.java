package top.hanlinqi.core.serializer;

import top.hanlinqi.core.enums.SerializerType;

/**
 * @program: ISerializer
 * @author: hanLinQi
 * @create: 2023-03-07 17:35
 **/
public interface ISerializer {

    /**
     * 序列化
     * @param t 被序列化对象
     * @param <T> 对象
     * @return
     */
    <T> byte[] serializer(T t);

    /**
     * 反序列化
     * @param data 字节数组
     * @param <T> 对象
     * @param tClass 指定类
     * @return
     */
    <T> T deSerializer(byte[] data, Class<T> tClass);

    /**
     * 获取序列化类型（目前仅支持Java序列化和Json序列化）
     * @return
     */
    byte getSerializerType();
}
