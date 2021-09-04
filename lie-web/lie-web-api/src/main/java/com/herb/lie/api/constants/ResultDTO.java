package com.herb.lie.api.constants;

import lombok.Data;

/**
 * 基本返回数据类型
 * @author zwt
 * @version 1.0
 * @date 2021年9月4日
 */

@Data
public class ResultDTO {

    private String system;

    private int code;

    private String msg;

    private Object data;

    public ResultDTO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultDTO(String system, int code, String msg, Object data) {
        this.system = system;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultDTO(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
