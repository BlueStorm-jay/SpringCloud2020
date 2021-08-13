package com.yun.service;

import com.yun.model.entity.RuleLog;

import java.util.List;

/**
 * @author zhouxingchao
 * @date 2021/8/13 13:34
 */
public interface RuleLogService {

    /**
     * 插入单条联动日志
     * @param ruleLog 联动日志实体类
     * @return Boolean
     */
    Boolean insert(RuleLog ruleLog);

    /**
     * 分页查询
     * @param pageNo 当前页
     * @param pageSize 页面大小
     * @return 联动日志集合
     */
    List<RuleLog> find(Integer pageNo, Integer pageSize);
}
