package com.yun.service;


import com.yun.model.entity.Message;

import java.util.List;

/**
 * @author zhouxingchao
 * @date 2021/8/12 10:12
 */
public interface MessageService {

    /**
     * 插入
     *
     * @param message 设备消息
     * @return Boolean
     */
    Boolean insert(Message message);

    /**
     * 根据uuid分页查询
     *
     * @param msgType  消息类型
     * @param pageNo   当前页
     * @param pageSize 页面大小
     * @return List<Message> 设备消息集合
     */
    List<Message> findByMsgType(Integer pageNo, Integer pageSize, Integer msgType);

}
