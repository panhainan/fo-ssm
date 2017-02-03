package com.panhainan.web;

import com.panhainan.common.CommonResult;
import com.panhainan.dto.UserSignInResult;
import com.panhainan.dto.UserSignUpResult;
import com.panhainan.service.UserService;
import com.panhainan.vo.UserSignInForm;
import com.panhainan.vo.UserSignUpForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public CommonResult<UserSignInResult> signIn(UserSignInForm userSignInForm) {
        logger.info("userSignInForm={}", userSignInForm);
        try {
            UserSignInResult userSignInResult = userService.signIn(userSignInForm);
            return new CommonResult<>(true, userSignInResult);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new CommonResult<>(false, e.getMessage());
        }
    }
}
