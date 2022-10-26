package com.course.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.course.pojo.BloodSugarRecord;
import com.course.pojo.User;
import com.course.result.CodeMsg;
import com.course.result.Result;
import com.course.service.BSRService;
import com.course.validator.NeedAuth;
import com.course.vo.BSRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @author tyf
 * @description 血糖记录 Controller
 * @date 12:39 2022/5/14
 **/
@Controller
@RequestMapping("/bsr")
public class BSRController {

    @Autowired
    BSRService bsrService;


    @ResponseBody
    @NeedAuth
    @GetMapping("/result")
    public Result<String> getMonthBSR(User user) {
        List<BloodSugarRecord> records = bsrService.getMonthRecord(user.getId());
        HashMap<String, BigDecimal> mp = new HashMap<>();
        for(BloodSugarRecord record : records){
           mp.put(DateUtil.format(record.getRecordTime(),"yyyy-MM-dd HH:mm:ss"), record.getValue());
        }
        return Result.success(JSONUtil.toJsonStr(mp));
    }

    @ResponseBody
    @NeedAuth
    @PostMapping("/update")
    public Result<CodeMsg> updateBSR(User user, @RequestBody @Validated BSRVO bsrVo) {
        bsrVo.setUserId(user.getId());
        bsrService.updateBSValue(bsrVo);
        return Result.success(CodeMsg.UPDATE_BSR_SUCCESSFUL);
    }


}
