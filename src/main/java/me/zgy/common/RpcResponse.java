package me.zgy.common;

import lombok.Data;

/**
 * Created by Rayee on 2017/10/1.
 */
@Data
public class RpcResponse {

    private String requestId;

    private Throwable error;

    private Object result;

}
