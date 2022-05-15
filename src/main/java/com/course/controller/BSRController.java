package com.course.controller;

import cn.hutool.json.JSONUtil;
import com.course.pojo.BloodSugarRecord;
import com.course.pojo.User;
import com.course.result.CodeMsg;
import com.course.result.Result;
import com.course.service.BSRService;
import com.course.vo.BSRVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/result")
    public Result<String> getMonthBSR(User user) {
        List<BloodSugarRecord> record = bsrService.getMonthRecord(user.getId());
        String ret = JSONUtil.toJsonStr(record);
        return Result.success(ret);
    }

    @ResponseBody
    @PostMapping("/update")
    public Result<CodeMsg> updateBSR(User user, @RequestBody @Validated BSRVo bsrVo) {
        bsrVo.setUserId(user.getId());
        bsrService.updateBSValue(bsrVo);
        return Result.success(CodeMsg.UPDATE_BSR_SUCCESSFUL);
    }


}
