package com.yun.controller;

import com.yun.model.entity.OperateLog;
import com.yun.model.entity.RuleLog;
import com.yun.service.RuleLogService;
import com.yun.springcloud.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhouxingchao
 * @date 2021/8/13 14:04
 */
@RestController
@RequestMapping("/ruleLogs")
public class RuleLogController {

    @Autowired
    private RuleLogService ruleLogService;

    /**
     * 上传联动日志
     * @param ruleLog 联动日志实体类
     * @return Boolean
     */
    @PostMapping("")
    public Result<Boolean> insert(@RequestBody RuleLog ruleLog) {
        return Result.ok(ruleLogService.insert(ruleLog));
    }

    /**
     * 获取联动日志
     * @param pageNo 当前页
     * @param pageSize 页面大小
     * @return Result<List<RuleLog>>
     */
    @GetMapping("")
    @ResponseBody
    public Result<List<RuleLog>> findByUUId(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        return Result.ok(ruleLogService.find(pageNo, pageSize));
    }
}
