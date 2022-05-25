package com.course.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.course.pojo.BloodSugarRecord;
import com.course.pojo.InsulinRecord;
import com.course.pojo.User;
import com.course.result.CodeMsg;
import com.course.result.Result;
import com.course.service.INRService;
import com.course.validator.NeedAuth;
import com.course.vo.INRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @author tyf
 * @description 胰岛素接口
 * @date 10:23 2022/5/15
 **/
@Controller
@RequestMapping("/inr")
public class INRController {

    @Autowired
    INRService inrService;


    @ResponseBody
    @GetMapping("/result")
    @NeedAuth
    public Result<String> getMonthINR(User user) {
        List<InsulinRecord> records = inrService.getMonthRecord(user.getId());
        HashMap<String, BigDecimal> mp = new HashMap<>();
        for(InsulinRecord record: records){
            mp.put(DateUtil.format(record.getRecordTime(),"yyyy-MM-dd HH:mm:ss"), record.getValue());
        }
        String ret = JSONUtil.toJsonStr(mp);
        return Result.success(ret);
    }

    @ResponseBody
    @NeedAuth
    @PostMapping("/update")
    public Result<CodeMsg> updateBSR(User user, @RequestBody @Validated INRVO inrVo) {
        inrVo.setUserId(user.getId());
        inrService.updateINValue(inrVo);
        return Result.success(CodeMsg.UPDATE_IR_SUCCESSFUL);
    }
}
