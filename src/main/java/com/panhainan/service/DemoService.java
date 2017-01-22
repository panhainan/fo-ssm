package com.panhainan.service;

import com.panhainan.entity.Demo;

/**
 * 测试案例：Demo的业务逻辑接口
 * 注意：目前没有对异常进行处理，没有支持事务
 * @author panhainan
 * @email panhainan@yeah.net
 * @version 1.0
 */
public interface DemoService {
    /**
     * 添加
     * @param demo 包含name的demo对象
     * @return  >=1:成功，并且结果表示插入的demo的记录的id；0:失败
     */
    int add(Demo demo);

    /**
     * 移除
     * @param id demo的id
     * @return true:成功；false:失败
     */
    boolean remove(int id);

    /**
     * 获取
     * @param id demo的id
     * @return 对应id的demo信息
     */
    Demo get(int id);

    /**
     * 修改
     * @param demo 包含name的demo对象
     * @return true:成功；false:失败
     */
    boolean edit(Demo demo);


}
