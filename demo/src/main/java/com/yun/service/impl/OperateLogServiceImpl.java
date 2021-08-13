package com.yun.service.impl;

import com.yun.model.entity.OperateLog;
import com.yun.service.OperateLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhouxingchao
 * @date 2021/8/13 9:54
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Resource
    private MongoTemplate mongoTemplate;

    private static final String COLLECTION_NAME = "IOT_OPERATELOGS";

    /**
     * 插入一条操作日志
     * @param uuid 设备id
     * @param operateLog 操作日志对象
     * @return Boolean
     */
    @Override
    public Boolean insert(String uuid, OperateLog operateLog) {
        if(StringUtils.isBlank(uuid)){
            return Boolean.FALSE;
        }
        operateLog.setUuid(uuid);
        operateLog.setTime(LocalDateTime.now());
        mongoTemplate.insert(operateLog,COLLECTION_NAME);
        return Boolean.TRUE;
    }

    /**
     * 根据设备id分页查询
     * @param uuid uuid
     * @param pageNo 当前页
     * @param pageSize 页面大小
     * @return List<OperateLogBO>  操作日志业务对象集合
     */
    @Override
    public List<OperateLog> findByUuid(String uuid, Integer pageNo, Integer pageSize) {
        if(StringUtils.isBlank(uuid)){
            return null;
        }
        Query query = new Query();
        //条件
        query.addCriteria(Criteria.where("uuid").is(uuid));

        if (pageNo == null || pageNo == 0) {
            //页码默认为1
            pageNo = 1;
        }
        //分页
        query.with(PageRequest.of(pageNo-1,pageSize));
        //排序
        query.with(Sort.by(Sort.Direction.DESC,"time"));

        return mongoTemplate.find(query, OperateLog.class);
    }
}
