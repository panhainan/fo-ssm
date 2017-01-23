package com.panhainan.service;

import com.panhainan.dto.UserSignInResult;
import com.panhainan.dto.UserSignUpResult;
import com.panhainan.vo.UserSignInForm;
import com.panhainan.vo.UserSignUpForm;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @Test
    public void testSignUp() throws Exception {
        UserSignUpForm userSignUpForm= new UserSignUpForm("fireoct","123456","123456@qq.com");
        UserSignUpResult userSignUpResult = userService.signUp(userSignUpForm);
        logger.info("userSignUpResult={}",userSignUpResult);
    }

    @Test
    public void testSignIn() throws Exception {
        UserSignInForm userSignInForm = new UserSignInForm("fireoct","1213456");
        UserSignInResult userSignInResult = userService.signIn(userSignInForm);
        logger.info("userSignInResult={}",userSignInResult);
    }

    @Test
    public void testSignOut() throws Exception {

    }
}