package com.panhainan.controller;

import com.panhainan.common.CommonResult;
import com.panhainan.pojo.Demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试案例：Demo的控制器接口
 * 注意：这里使用了HTTP请求返回结果公共类CommonResult，对于返回结果的设计还需要根据具体需求进行处理
 *
 * @author panhainan
 * @version 1.0
 * @email panhainan@yeah.net
 * @date 2017/01/12
 */
@Controller
@RequestMapping(value = "/api/params")
public class ArrayParamsController {

    @ResponseBody
    @RequestMapping(value = "/list-json", method = RequestMethod.POST)
    public CommonResult post01(@RequestBody List<Demo> demoList) {
        System.out.println("JSON List Params :");
        for(Demo demo :demoList){
            System.out.println(demo);
        }
        return new CommonResult(CommonResult.SUCCESS_CODE,"List Params",demoList);
    }
    @ResponseBody
    @RequestMapping(value = "/list-json2", method = RequestMethod.POST)
    public CommonResult post06(@RequestBody  Demo[] demoList) {
        System.out.println("JSON List Params :");
        for(Demo demo :demoList){
            System.out.println(demo);
        }
        return new CommonResult(CommonResult.SUCCESS_CODE,"List Params",demoList);
    }
    @ResponseBody
    @RequestMapping(value = "/list-form2", method = RequestMethod.POST)
    public CommonResult post02(@RequestParam(value = "demoList") ArrayList<Demo> demoList) {
        System.out.println("FORM List Params :");
        for(Demo demo :demoList){
            System.out.println(demo);
        }
        return new CommonResult(CommonResult.SUCCESS_CODE,"List Params",demoList);
    }
    @ResponseBody
    @RequestMapping(value = "/list-form3", method = RequestMethod.POST)
    public CommonResult post03(ArrayList<Demo> demoList) {
        System.out.println("FORM List Params :");
        for(Demo demo :demoList){
            System.out.println(demo);
        }
        return new CommonResult(CommonResult.SUCCESS_CODE,"List Params",demoList);
    }
    @ResponseBody
    @RequestMapping(value = "/list-form4", method = RequestMethod.POST)
    public CommonResult post04(Demo[] demoList) {
        System.out.println("FORM List Params :");
        for(Demo demo :demoList){
            System.out.println(demo);
        }
        return new CommonResult(CommonResult.SUCCESS_CODE,"List Params",demoList);
    }
    @ResponseBody
    @RequestMapping(value = "/list-form5", method = RequestMethod.POST)
    public CommonResult post05(@RequestParam(value = "demoList[]") Demo[] demoList) {
        System.out.println("FORM List Params :");
        for(Demo demo :demoList){
            System.out.println(demo);
        }
        return new CommonResult(CommonResult.SUCCESS_CODE,"List Params",demoList);
    }
    @ResponseBody
    @RequestMapping(value = "/list-form6", method = RequestMethod.POST)
    public CommonResult post07(@RequestParam(value = "[]") Demo[] demoList) {
        System.out.println("FORM List Params :");
        for(Demo demo :demoList){
            System.out.println(demo);
        }
        return new CommonResult(CommonResult.SUCCESS_CODE,"List Params",demoList);
    }
    @ResponseBody
    @RequestMapping(value = "/list-form7", method = RequestMethod.POST)
    public CommonResult post08(Integer[] ids) {
        System.out.println("FORM List Params :");
        for(Integer id :ids){
            System.out.println(id);
        }
        return new CommonResult(CommonResult.SUCCESS_CODE,"List Params",ids);
    }
    @ResponseBody
    @RequestMapping(value = "/list-form8", method = RequestMethod.POST)
    public CommonResult post09(int[] ids) {
        System.out.println("FORM List Params :");
        for(Integer id :ids){
            System.out.println(id);
        }
        return new CommonResult(CommonResult.SUCCESS_CODE,"List Params",ids);
    }
}
