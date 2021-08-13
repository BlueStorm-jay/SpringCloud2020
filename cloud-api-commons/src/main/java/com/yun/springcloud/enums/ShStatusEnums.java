package com.yun.springcloud.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * Created by liliang on 2021.03.23
 * @author liliang
 * 调用状态码
 */
@Getter
public enum ShStatusEnums {
    /**
     * 调用成功状态码
     */
    SUCCESS(10000,"接口调用成功","interfacade.invork.success"),

    /**
     * 服务不可用
     */
    SERVICE_UNENABLE(20000,"服务不可用","service.unabled"),

    /**
     * 权限不足
     */
    NO_AUTH_PERMISSON(20001,"认证授权权限失败","auth.fail"),


    /**
     * 缺少必要参数
     */
    MISSING_PARAMETER(40000,"缺少必选参数","missing.required.parameter"),

    /**
     * 非法的参数
     */
    INVALID_PARAMETER(40001,"非法的参数","invalid.parameter"),

    /**
     * 参数绑定异常
     */
    BIND_METHOD_PARAMETER(40002,"参数绑定异常","bind.parameter.exception"),

    /**
     * 校验参数异常
     */
    CHECK_PARAMETER(40003,"校验参数异常","check.parameter.exception"),

    /**
     * 业务处理失败参数
     */
    BUSSINESS_ERROR(40004,"业务处理失败","bussiness.handler.exception"),

    /**
     * 访问权限不足
     */
    NO_ACCESS_PERMISSON(40006,"访问权限不足","forbid.accessed"),

    /**
     * 访问限流
     */
    LIMIT_BLOCK(40005,"访问频次限流","accessed.limit.flow"),

    /**
     * fegin 调用异常内部错误
     */
    FEGIN_INVORK_ERROR(40007,"Fegin 组件调用异常","fegin.invork.exception"),

    /**
     * 文件操作相关错误
     */
    FILE_UPLOAD_ERROR(50000,"文件上传异常","file.upload.error"),
    FILE_UNSUPPORTED(50001,"文件不支持","file.unsupported"),


    /**
     * 具体业务模块错误码
     * 前三位为模块，中间三位错误原因,最后两位预留
     */
    /** gateway 层 */
    SIGN_ERROR(10100001,"签名校验失败", "user.not.exist"),

    /** 用户模块 */
    USER_NOT_EXIST(10200001,"用户不存在", "user.not.exist"),

    /** 网关模块 */
    HOUSE_NOT_EXIST(10300001,"网关不存在", "gateway.not.exist"),
    /**APP升级管理模块*/
    APP_VERSION_NOT_EXIST(10400001,"APP版本不存在","app version does not exist"),
    /**网关升级管理模块*/
    FW_VERSION_NOT_EXIST(10400002,"网关版本不存在","house fw version not exist"),

    /** APP用户模块 */
    APPUSER_NOT_EXIST(10500001, "APP用户不存在","appuser.not.exist"),
    APPUSER_EXIST(10500002, "APP用户已存在","appuser.exist"),
    APPUSER_PWD_ERROR(10500003, "密码错误","appuser.pwd.error"),
    VERIFY_CODE_TYPE_UNSUPPORTED(10500004, "不支持的验证码类型","verify.code.type.unsupported"),
    VERIFY_CODE_ERROR(10500005, "无效的验证码","verify.code.error"),

    /** 客户端 模块 */
    CLIENT_NOT_EXIST(10600001,"客户端不存在", "client.not.exist"),

    /** 秘钥模块 */
    SERCET_NOT_EXIST(10700001,"秘钥不存在", "sercet.not.exist"),

    /** 消息模块 */
    MESSAGE_SEND_ERROR(1080001, "消息发送失败", "message.send.error"),
    ;

    private Integer code;

    private String msg;

    private String defaultSubCode;

    ShStatusEnums(Integer code, String msg, String defaultSubCode) {
        this.code = code;
        this.msg = msg;
        this.defaultSubCode = defaultSubCode;
    }

    /**
     * 获取指定code 的实例
     * @param code
     * @return
     */
    public static final ShStatusEnums codeToShStatusEnums(int code) {
       return Arrays.stream(ShStatusEnums.values()).filter(s -> s.getCode() == code).findFirst().orElse(null);
    }
}
