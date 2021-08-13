package com.yun.service.impl;

import com.yun.model.entity.Message;
import com.yun.service.MessageService;
import org.bson.types.ObjectId;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

import java.util.List;
import java.util.TimeZone;

/**
 * @author zhouxingchao
 * @date 2021/8/12 10:24
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MongoTemplate mongoTemplate;

    private static final String COLLECTION_NAME = "IOT_MESSAGES";


    /**
     * 插入
     *
     * @param message 设备消息
     * @return Boolean
     */
    @Override
    public Boolean insert(Message message) {
        //设置时区
        message.setTime(LocalDateTime.now());
        mongoTemplate.insert(message, COLLECTION_NAME);
        return Boolean.TRUE;
    }

    /**
     * 根据uuid分页查询
     *
     * @param pageNo   当前页
     * @param pageSize 页面大小
     * @param msgType  消息类型
     * @return List<Message> 设备消息集合
     */
    @Override
    public List<Message> findByMsgType(Integer pageNo, Integer pageSize, Integer msgType) {
        Query query = new Query();
        if (msgType != null && msgType != 0) {
            //查询条件
            query.addCriteria(Criteria.where("type").is(msgType));
        }
        //排序
        query.with(Sort.by(Sort.Direction.DESC, "time"));

        if (pageNo == null || pageNo == 0) {
            //页码默认为1
            pageNo = 1;
        }
        //分页,page从第0开始
        query.with(PageRequest.of(pageNo - 1, pageSize));

        List<Message> messages = mongoTemplate.find(query, Message.class);

        return messages;
    }

    public Message findOne(String id) {
        return mongoTemplate.findById(new ObjectId(id), Message.class);
    }
}




















