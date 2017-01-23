package com.panhainan.service.impl;

import com.panhainan.dao.UserDao;
import com.panhainan.dto.UserSignInResult;
import com.panhainan.dto.UserSignUpResult;
import com.panhainan.entity.User;
import com.panhainan.exception.DataExistException;
import com.panhainan.exception.DataInsertException;
import com.panhainan.exception.DataMatchException;
import com.panhainan.exception.SystemException;
import com.panhainan.service.UserService;
import com.panhainan.vo.UserSignInForm;
import com.panhainan.vo.UserSignUpForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试案例：User的业务逻辑实现类
 *
 * @author panhainan
 * @version 1.0
 * @email panhainan@yeah.net
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserDao userDao;

    @Override
    public UserSignUpResult signUp(UserSignUpForm userSignUpForm)
            throws SystemException {
        try {
            // 检查用户账户名和邮箱是否已存在
            if(checkUserIsExistByName(userSignUpForm.getUserName())){
                throw new DataInsertException("该用户名已经存在");
            }
            if(checkUserIsExistByEmail(userSignUpForm.getUserEmail())){
                throw new DataInsertException("该邮箱已经存在");
            }
            User user = new User(
                    userSignUpForm.getUserName(),
                    userSignUpForm.getUserPass(),
                    userSignUpForm.getUserEmail());
            int insertCount = userDao.insert(user);
            if (insertCount > 0) {
                return new UserSignUpResult(true, userSignUpForm.getUserName());
            }else{
                throw new DataInsertException("数据插入失败");
            }
        }catch (DataInsertException e){
            throw e;
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new SystemException("系统异常："+e.getMessage());
        }
    }

    private boolean checkUserIsExistByName(String userName){
        User user = userDao.selectByUserName(userName);
        if(user!=null){
            return true;
        }
        return false;
    }
    private  boolean checkUserIsExistByEmail(String userEmail){
        User user = userDao.selectByUserEmail(userEmail);
        if(user!=null){
            return true;
        }
        return false;
    }

    @Override
    public UserSignInResult signIn(UserSignInForm userSignInForm) {
        // TODO 密码加密解密处理

        User user = userDao.selectByUserName(userSignInForm.getUserName());
        if(user==null){
            throw new DataExistException("用户不存在");
        }
        if(!user.getUserPass().equals(userSignInForm.getUserPass())){
            throw new DataMatchException("用户名或密码错误");
        }else{
            // TODO 用户登录状态保存处理
            return new UserSignInResult(true,userSignInForm.getUserName());
        }
    }

    @Override
    public void signOut() {

    }
}
