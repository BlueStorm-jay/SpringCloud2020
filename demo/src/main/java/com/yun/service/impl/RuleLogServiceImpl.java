package com.yun.service.impl;

import com.yun.model.entity.RuleLog;
import com.yun.service.RuleLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhouxingchao
 * @date 2021/8/13 13:47
 */
@Service
public class RuleLogServiceImpl implements RuleLogService {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String COLLECTION_NAME = "IOT_RULELOGS";

    /**
     * 插入单条联动日志
     * @param ruleLog 联动日志实体类
     * @return Boolean
     */
    @Override
    public Boolean insert(RuleLog ruleLog) {
        ruleLog.setTime(LocalDateTime.now());
        mongoTemplate.insert(ruleLog, COLLECTION_NAME);
        return Boolean.TRUE;
    }

    /**
     * 分页查询
     * @param pageNo 当前页
     * @param pageSize 页面大小
     * @return 联动日志集合
     */
    @Override
    public List<RuleLog> find(Integer pageNo, Integer pageSize) {
        Query query = new Query();
        //排序
        query.with(Sort.by(Sort.Direction.DESC, "time"));

        if (pageNo == null || pageNo == 0) {
            //页码默认为1
            pageNo = 1;
        }
        //分页,page从第0开始
        query.with(PageRequest.of(pageNo - 1, pageSize));

        return mongoTemplate.find(query, RuleLog.class);
    }
}
