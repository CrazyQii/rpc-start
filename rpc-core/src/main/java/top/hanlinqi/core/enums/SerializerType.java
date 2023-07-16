package top.hanlinqi.core.enums;

/**
 * @program: SerialType
 * @description:
 * @author: hanLinQi
 * @create: 2023-02-28 10:00
 **/

public enum SerializerType {

    JSON_SERIAL((byte)0),
    JAVA_SERIAL((byte)1);

    private byte code;

    SerializerType(byte code) {
        this.code=code;
    }

    public byte code(){
        return this.code;
    }
}
