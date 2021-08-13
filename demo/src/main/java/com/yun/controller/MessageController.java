package com.yun.controller;

import com.yun.model.entity.Message;
import com.yun.service.MessageService;
import com.yun.springcloud.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhouxingchao
 * @date 2021/8/12 14:35
 */
@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 获取消息列表
     *
     * @param pageNo   当前页
     * @param pageSize 页面大小
     * @param msgType  消息类型
     * @return Result<List < Message>>
     */
    @GetMapping("")
    @ResponseBody
    public Result<List<Message>> findByMsgType(Integer pageNo, Integer pageSize, Integer msgType) {
        return Result.ok(messageService.findByMsgType(pageNo, pageSize, msgType));
    }

    /**
     * 新增消息
     *
     * @param uuid  设备id
     * @param gatewayId 网关id
     * @param msgType 消息类型
     * @return
     */
    @PostMapping("")
    public Result<Boolean> insert(String uuid, String gatewayId, Integer msgType) {
        Message message = Message.builder().uuid(uuid).gatewayId(gatewayId).type(msgType).build();
        return Result.ok(messageService.insert(message));
    }
}
