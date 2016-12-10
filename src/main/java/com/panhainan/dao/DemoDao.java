package com.panhainan.dao;

import com.panhainan.pojo.Demo;
import org.springframework.stereotype.Repository;

/**
 * 测试案例：Demo的数据访问接口
 * @author panhainan
 * @email panhainan@yeah.net
 * @version 1.0
 */
@Repository("demoDao")
public interface DemoDao {
    /**
     * 插入
     * @param demo 包含name、opreateTime的demo对象
     * @return 受影响的行数
     */
    int insert(Demo demo);

    /**
     * 删除
     * @param id 数据库中demo记录的id
     * @return 受影响的行数
     */
    int delete(int id);

    /**
     * 查找
     * @param id 数据库中demo记录的id
     * @return Demo
     */
    Demo select(int id);
    /**
     * 更新
     * @param demo 包含name、opreateTime的demo对象
     * @return 受影响的行数
     */
    int update(Demo demo);

}
