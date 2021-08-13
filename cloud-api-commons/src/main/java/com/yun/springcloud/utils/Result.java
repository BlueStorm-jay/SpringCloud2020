
package com.yun.springcloud.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yun.springcloud.enums.ShStatusEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by liliang on 2021.03.15
 *
 * @author liliang
 * <p>
 * 响应信息主体
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回码
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private int code;

    /**
     * 返回成功与否
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private boolean success;

    /**
     * 返回码描述
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String msg;

    /**
     * 错误模块
     */
    private String module;

    /**
     * 明细返回码
     */
    @JsonIgnore
    private String subCode;

    /**
     * 明细返回码描述
     */
    @JsonIgnore
    private String subMsg;

    /**
     * 返回的数据
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private T data;

    /**
     * 返回时间搓
     *
     * @param <T>
     * @return
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String ts;

    public static <T> Result<T> ok() {
        return restResult(null, ShStatusEnums.SUCCESS, null, true);
    }

    public static <T> Result<T> ok(T data) {
        return restResult(data, ShStatusEnums.SUCCESS, null, true);
    }

    public static <T> Result<T> ok(T data, String msg) {
        return restResult(data, ShStatusEnums.SUCCESS, null, true);
    }

    public static <T> Result<T> failed(String module, String subMsg) {
        return restResult(null, ShStatusEnums.SERVICE_UNENABLE, module, false);
    }

    public static <T> Result<T> failed(ShStatusEnums statusEnums, String module, String subCode, String subMsg) {
        return restResult(null, statusEnums, module, false);
    }

    public static <T> Result<T> failed(ShStatusEnums statusEnums, String module) {
        return restResult(null, statusEnums, module, false);
    }

    private static <T> Result<T> restResult(T data, ShStatusEnums statusEnums, String module
            , boolean success) {
        Result<T> apiResult = new Result<>();
        apiResult.setSuccess(success);
        apiResult.setCode(statusEnums.getCode());
        apiResult.setData(data);
        apiResult.setMsg(statusEnums.getMsg());
        apiResult.setTs(Calendar.getInstance().getTimeInMillis() + "");
        apiResult.setModule(module);
        return apiResult;
    }

}
