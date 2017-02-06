package com.panhainan.service;

import com.panhainan.dto.CheckResult;
import com.panhainan.dto.UserSignInResult;
import com.panhainan.dto.UserSignUpResult;
import com.panhainan.vo.UserSignInForm;
import com.panhainan.vo.UserSignUpForm;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试案例：User的业务逻辑接口
 * @author panhainan
 * @email panhainan@yeah.net
 * @version 1.0
 */
public interface UserService {

    UserSignUpResult signUp(UserSignUpForm userSignUpForm);
    CheckResult checkUserNameIsExist(String userName);
    CheckResult checkUserEmailIsExist(String userEmail);

    UserSignInResult signIn(UserSignInForm userSignInForm);

}
