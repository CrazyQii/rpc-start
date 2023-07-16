package top.hanlinqi.core.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: RpcRequest
 * @description: rpc请求体格式
 * @author: hanLinQi
 * @create: 2023-02-27 18:09
 **/
@Data
public class RpcRequest implements Serializable {

    private String className;
    private String methodName;
    private Object[] params;
    private Class<?>[] paramTypes;
}
