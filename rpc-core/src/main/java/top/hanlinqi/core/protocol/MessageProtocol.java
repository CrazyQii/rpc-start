package top.hanlinqi.core.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: RpcProtocol
 * @description: rpc协议
 * @author: hanLinQi
 * @create: 2023-02-27 18:11
 **/
@Data
public class MessageProtocol<T> implements Serializable {

    private Header header;
    private T content;
}
