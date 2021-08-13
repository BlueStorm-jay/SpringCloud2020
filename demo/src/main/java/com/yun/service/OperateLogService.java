package com.yun.service;

import com.yun.model.entity.OperateLog;

import java.util.List;

/**
 * @author zhouxingchao
 * @date 2021/8/13 9:29
 */
public interface OperateLogService {

    /**
     * 插入一条操作日志
     *
     * @param uuid         设备id
     * @param operateLogBO 操作日志业务对象
     * @return Boolean
     */
    Boolean insert(String uuid, OperateLog operateLogBO);

    /**
     * 根据设备id分页查询
     *
     * @param uuid     uuid
     * @param pageNo   当前页
     * @param pageSize 页面大小
     * @return List<OperateLogBO>  操作日志业务对象集合
     */
    List<OperateLog> findByUuid(String uuid, Integer pageNo, Integer pageSize);
}
