package top.hanlinqi.core.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: RpcResponse
 * @description: rpc响应体
 * @author: hanLinQi
 * @create: 2023-02-27 18:11
 **/
@Data
public class RpcResponse implements Serializable {

    private Object data;
    private String msg;
}
