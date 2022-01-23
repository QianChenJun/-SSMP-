package com.teng.controller.utils;

import lombok.Data;

@Data
public class Result {

    private Boolean flag;

    private Object data;

    private String msg;

    public Result() {
    }

    public Result(Boolean flag) {
        this.flag = flag;
    }

    public Result(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    // 给出现异常的情况使用
    public Result(String msg) {
        this.flag = false;
        this.msg = msg;
    }

}
