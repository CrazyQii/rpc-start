package top.hanlinqi.core.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: Header
 * @description:
 * @author: hanLinQi
 * @create: 2023-02-27 17:27
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Header {
    /*
    +----------------------------------------------+
    | 魔数 2byte | 序列化算法 1byte | 请求类型 1byte  |
    +----------------------------------------------+
    | 消息 ID 8byte     |      数据长度 4byte       |
    +----------------------------------------------+
    */
    // 魔数-用来验证报文身份
    private short magic;
    // 序列化类型
    private byte serialType;
    // 操作类型
    private byte reqType;
    // 消息id
    private long requestId;
    // 数据长度
    private int length;
}
