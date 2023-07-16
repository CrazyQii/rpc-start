package top.hanlinqi.core.serializer;


import top.hanlinqi.core.enums.SerializerType;

import java.io.*;

/**
 * @program: JavaSerial
 * @description: Java序列化
 * @author: hanLinQi
 * @create: 2023-02-28 10:04
 **/

public class JavaSerializer implements ISerializer {

    @Override
    public <T> byte[] serializer(T t) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(t);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public <T> T deSerializer(byte[] data, Class<T> tClass) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (T) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public byte getSerializerType() {
        return SerializerType.JAVA_SERIAL.code();
    }
}
