package com.yun.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author zhouxingchao
 * @date 2021/8/13 9:11
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "IOT_OPERATELOGS")
public class OperateLog {
    public OperateLog(String loginName,String operate,String param){
        this.loginName = loginName;
        this.operate = operate;
        this.param = param;
    }
    /**
     * 主键id
     */
    @Id
    private String id;

    /**
     * 账户
     */
    private String loginName;

    /**
     * 设备id
     */
    private String uuid;

    /**
     * 操作
     */
    private String operate;

    /**
     * 参数
     */
    private String param;

    /**
     * 日期时间
     */
    private LocalDateTime time;

}
