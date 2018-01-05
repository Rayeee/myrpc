package me.zgy.common;

import lombok.Data;

/**
 * Created by Rayee on 2017/10/1.
 */
@Data
public class RpcRequest {

    private String requestId;

    private String className;

    private String methodName;

    private Class<?>[] parameterTypes;

    private Object[] parameters;

}
