package com.panhainan.controller;

import com.panhainan.common.CommonResult;
import com.panhainan.pojo.Demo;
import com.panhainan.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 测试案例：Demo的控制器接口
 * 注意：这里使用了HTTP请求返回结果公共类CommonResult，对于返回结果的设计还需要根据具体需求进行处理
 *
 * @author panhainan
 * @version 1.0
 * @email panhainan@yeah.net
 */
@Controller
@RequestMapping(value = "/api/demo")
public class DemoController {
    /**
     * Demo业务逻辑实现类的实例
     */
    @Autowired
    private DemoService demoService;

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommonResult add(@RequestBody Demo demo) {
        boolean isSuccess = true;
        String msg = null;
        CommonResult commonResult = null;
        int resultData = 0;
        try {
            resultData = demoService.add(demo);
            //这里还要对resultData进行判断处理，根据service层返回的结果
        } catch (Exception e) {
            //这里没有做具体处理，需要根据具体情况catch异常并做相应的提示msg
            msg = e.getMessage();
            isSuccess = false;
        } finally {
            if (isSuccess) {
                commonResult = new CommonResult(CommonResult.SUCCESS_CODE, msg, resultData);
            } else {
                commonResult = new CommonResult(CommonResult.FAIL_CODE, msg);
            }
        }
        return commonResult;
    }

    @ResponseBody
     @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
     public CommonResult delete(@PathVariable("id")int id) {
        boolean isSuccess = true;
        String msg = null;
        CommonResult commonResult = null;
        boolean resultData = true;
        try {
            resultData = demoService.remove(id);
        } catch (Exception e) {
            //这里没有做具体处理，需要根据具体情况catch异常并做相应的提示msg
            msg = e.getMessage();
            isSuccess = false;
        } finally {
            if (isSuccess) {
                commonResult = new CommonResult(CommonResult.SUCCESS_CODE, msg, resultData);
            } else {
                commonResult = new CommonResult(CommonResult.FAIL_CODE, msg);
            }
        }
        return commonResult;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult get(@PathVariable("id")int id) {
        boolean isSuccess = true;
        String msg = null;
        CommonResult commonResult = null;
        Demo resultData = null;
        try {
            resultData = demoService.get(id);
        } catch (Exception e) {
            //这里没有做具体处理，需要根据具体情况catch异常并做相应的提示msg
            msg = e.getMessage();
            isSuccess = false;
        } finally {
            if (isSuccess) {
                commonResult = new CommonResult(CommonResult.SUCCESS_CODE, msg, resultData);
            } else {
                commonResult = new CommonResult(CommonResult.FAIL_CODE, msg);
            }
        }
        return commonResult;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public CommonResult update(@PathVariable("id")int id,@RequestBody Demo demo) {
        boolean isSuccess = true;
        String msg = null;
        CommonResult commonResult = null;
        boolean resultData = true;
        try {
            demo.setId(id);
            resultData = demoService.edit(demo);
        } catch (Exception e) {
            //这里没有做具体处理，需要根据具体情况catch异常并做相应的提示msg
            msg = e.getMessage();
            isSuccess = false;
        } finally {
            if (isSuccess) {
                commonResult = new CommonResult(CommonResult.SUCCESS_CODE, msg, resultData);
            } else {
                commonResult = new CommonResult(CommonResult.FAIL_CODE, msg);
            }
        }
        return commonResult;
    }
}
