package com.panhainan.web;

import com.panhainan.common.CommonResult;
import com.panhainan.common.CommonValue;
import com.panhainan.dto.CheckResult;
import com.panhainan.dto.UserSignInResult;
import com.panhainan.dto.UserSignUpResult;
import com.panhainan.service.UserService;
import com.panhainan.vo.UserSignInForm;
import com.panhainan.vo.UserSignUpForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by fo on 2017/1/23.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public CommonResult<UserSignUpResult> signUp(UserSignUpForm userSignUpForm) {
        logger.info("userSignUpForm={}", userSignUpForm);
        try {
            UserSignUpResult userSignUpResult = userService.signUp(userSignUpForm);
            return new CommonResult<>(true, userSignUpResult);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new CommonResult<>(false, e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public CommonResult<UserSignInResult> signIn(UserSignInForm userSignInForm, HttpServletRequest request) {
        logger.info("userSignInForm={}", userSignInForm);
        try {
            UserSignInResult userSignInResult = userService.signIn(userSignInForm);
            //判断登录成功则将用户名保存在session中
            if (userSignInResult.isSuccess()) {
                HttpSession userNameSession = request.getSession(true);
                userNameSession.setAttribute("userNameSession", userSignInResult.getUserName());
                userNameSession.setMaxInactiveInterval(CommonValue.USER_SESSION_TIMEOUT_MINUTE);
            }
            return new CommonResult<>(true, userSignInResult);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new CommonResult<>(false, e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/checkAccount", method = RequestMethod.POST)
    public CommonResult<CheckResult> checkAccount(String userName) {
        CheckResult checkResult = userService.checkUserNameIsExist(userName);
        return new CommonResult<>(true, checkResult);
    }
    @ResponseBody
    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    public CommonResult<CheckResult> checkEmail(String userEmail) {
        CheckResult checkResult = userService.checkUserEmailIsExist(userEmail);
        return new CommonResult<>(true, checkResult);
    }

    @ResponseBody
    @RequestMapping(value = "/signOut", method = RequestMethod.GET)
    public CommonResult signOut(HttpServletRequest request) {
        HttpSession userNameSession = request.getSession(true);
        userNameSession.removeAttribute("userNameSession");
        return new CommonResult(true);
    }

}
