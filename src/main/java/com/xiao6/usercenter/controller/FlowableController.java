package com.xiao6.usercenter.controller;

import com.xiao6.usercenter.util.AjaxResult;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.*;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.image.ProcessDiagramGenerator;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/flowable")
public class FlowableController {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;

    @Autowired
    private ProcessEngine processEngine;

    /**
     * .提交采购订单的审批请求
     *
     * @param userId 用户id
     */
    @PostMapping("/start/{userId}/{purchaseOrderId}")
    public AjaxResult startFlow(@PathVariable String userId, @PathVariable String purchaseOrderId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("purchaseOrderId", purchaseOrderId);
        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByKey("OrderApproval", map);
        String processId = processInstance.getId();
        String name = processInstance.getName();
        System.out.println(processId + ":" + name);
        return AjaxResult.success(processId + ":" + name);
    }

    /**
     * .获取用户的任务
     *
     * @param userId 用户id
     */
    @GetMapping("/getTasks/{userId}")
    public AjaxResult getTasks(@PathVariable String userId) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(userId).orderByTaskCreateTime().desc().list();
        return AjaxResult.success(tasks.toString());
    }

    /**
     * .审批通过
     */
    @PostMapping("/success/{taskId}")
    public AjaxResult success(@PathVariable String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            return AjaxResult.failed("流程不存在");
        }
        //通过审核
        HashMap<String, Object> map = new HashMap<>();
        map.put("approved", true);
        taskService.complete(taskId, map);
        return AjaxResult.success("流程审核通过！");
    }

    /**
     * .审批不通过
     */
    @PostMapping("/faile/{taskId}")
    public AjaxResult faile(@PathVariable String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            return AjaxResult.failed("流程不存在");
        }
        //通过审核
        HashMap<String, Object> map = new HashMap<>();
        map.put("approved", false);
        taskService.complete(taskId, map);
        return AjaxResult.success();
    }
}
