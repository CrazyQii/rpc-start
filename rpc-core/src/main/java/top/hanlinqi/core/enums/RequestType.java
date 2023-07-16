package top.hanlinqi.core.enums;

/**
 * @program: ReqType
 * @author: hanLinQi
 * @create: 2023-02-27 18:14
 **/
public enum RequestType {
    REQUEST((byte)1),
    RESPONSE((byte) 2),
    HEARTBEAT((byte) 3)
    ;

    private byte code;

    RequestType(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }

    public static RequestType findByCode(int code) {
        for (RequestType msgType: RequestType.values()) {
            if (msgType.code == code) {
                return msgType;
            }
        }
        return null;
    }
}
