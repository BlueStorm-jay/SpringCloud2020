package com.yun.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouxingchao
 * @date 2021/8/5 15:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResult<T> {

    //返回码
    private Integer code;
    //提示信息
    private String message;
    //数据
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
