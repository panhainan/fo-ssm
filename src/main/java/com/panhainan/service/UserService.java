package com.panhainan.service;

import com.panhainan.dto.UserSignInResult;
import com.panhainan.dto.UserSignUpResult;
import com.panhainan.vo.UserSignInForm;
import com.panhainan.vo.UserSignUpForm;

/**
 * 测试案例：User的业务逻辑接口
 * @author panhainan
 * @email panhainan@yeah.net
 * @version 1.0
 */
public interface UserService {

    UserSignUpResult signUp(UserSignUpForm userSignUpForm);

    UserSignInResult signIn(UserSignInForm userSignInForm);

    void/*TODO*/ signOut();


}
