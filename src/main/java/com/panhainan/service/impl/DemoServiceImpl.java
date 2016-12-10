package com.panhainan.service.impl;

import com.panhainan.dao.DemoDao;
import com.panhainan.pojo.Demo;
import com.panhainan.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试案例：Demo的业务逻辑实现类
 * 注意：目前没有对异常进行处理，没有支持事务
 * @author panhainan
 * @email panhainan@yeah.net
 * @version 1.0
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {

    /**
     * Demo数据访问层的实例
     */
    @Autowired
    private DemoDao demoDao;

    @Override
    public int add(Demo demo) {
        int affectedRows = demoDao.insert(demo);
        //这里可以抽出封装为一个工具类
        if(affectedRows>=1){
            return demo.getId();
        }else{
            return 0;
        }
    }


    @Override
    public boolean remove(int id) {
        int affectedRows = demoDao.delete(id);
        if(affectedRows>=1){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public Demo get(int id) {
        Demo demo = null;
        demo= demoDao.select(id);
        return demo;
    }


    @Override
    public boolean edit(Demo demo) {
        int affectedRows = demoDao.update(demo);
        if(affectedRows>=1){
            return true;
        }else{
            return false;
        }
    }
}
