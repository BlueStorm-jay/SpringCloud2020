package com.yun.model.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * 设备消息
 * @author zhouxingchao
 * @date 2021/8/11 11:16
 */
@Data
@Document("IOT_MESSAGES")
@Builder
public class Message {
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
     * 网关id
     */
    private String gatewayId;

    /**
     * 消息类型
     */
    private Integer type;
    /**
     * 日期时间
     */
    private LocalDateTime time;
}
