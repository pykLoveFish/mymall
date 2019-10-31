package com.pyk.mymall.controller;

import com.pyk.mymall.common.api.CommonResult;
import com.pyk.mymall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 会员登录注册管理
 */
@Controller
@Api(tags = "UmsMemberController",description = "会员登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {
    @Autowired
    UmsMemberService umsMemberService;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone){
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation("验证验证码")
    @RequestMapping(value = "/verifyAuthCode",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult verifyAuthCode(@RequestParam String telephone,
                                       @RequestParam String authCode){
        return umsMemberService.verifyAuthCode(telephone,authCode);
    }
}
