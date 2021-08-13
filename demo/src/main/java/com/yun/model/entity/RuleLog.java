package com.yun.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * 联动日志
 *
 * @author zhouxingchao
 * @date 2021/8/13 13:16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "IOT_RULELOGS")
public class RuleLog {

    public RuleLog(String uuid,String loginName,String ruleName){
        this.uuid = uuid;
        this.loginName = loginName;
        this.ruleName = ruleName;
    }

    /**
     * 主键id
     */
    @Id
    private String id;

    /**
     * 设备id
     */
    private String uuid;

    /**
     * 账户
     */
    private String loginName;

    /**
     *
     */
    private String ruleName;

    /**
     * 日期时间
     */
    private LocalDateTime time;
}
