package com.chuncan.ds.utils;

import lombok.Data;

/**
 * 结果返回工具类
 *
 * @author:YaoShuLi
 * @Date:2020/4/9 0009
 * @Time:15:07
 */
@Data
public class Message {

    public Message(String message,int code){
        this.message = message;
        this.code = code;
    }

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回结果码
     * 200 成功 500失败
     *
     */
    private int code;
}
