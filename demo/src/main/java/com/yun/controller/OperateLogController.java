package com.yun.controller;

import com.yun.model.entity.OperateLog;
import com.yun.service.OperateLogService;
import com.yun.springcloud.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhouxingchao
 * @date 2021/8/13 10:48
 */
@RestController
@RequestMapping("/operateLogs")
public class OperateLogController {
    @Autowired
    private OperateLogService operateLogService;

    /**
     * 上传操作日志
     * @param uuid 设备id
     * @param operateLog 操作日志对象
     * @return Result<Boolean>
     */
    @PostMapping("/{uuid}")
    public Result<Boolean> insert(@PathVariable(value = "uuid") String uuid, @RequestBody OperateLog operateLog) {
        return Result.ok(operateLogService.insert(uuid, operateLog));
    }

    /**
     * 获取操作日志
     * @param uuid 设备id
     * @param pageNo 当前页
     * @param pageSize 页面大小
     * @return Result<List<OperateLog>>
     */
    @GetMapping("/{uuid}")
    @ResponseBody
    public Result<List<OperateLog>> findByUuid(@PathVariable(value = "uuid") String uuid,
                                               @RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        return Result.ok(operateLogService.findByUuid(uuid, pageNo, pageSize));
    }
}
