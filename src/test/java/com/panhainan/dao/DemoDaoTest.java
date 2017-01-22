package com.panhainan.dao;

import com.panhainan.entity.Demo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;

public class DemoDaoTest extends BaseDaoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private DemoDao demoDao;

    @Test
    public void testInsert() throws Exception {
        Demo demo = new Demo();
        demo.setName("测试添加Demo");
        demo.setOpreateTime(new Date());
        int insertCount = demoDao.insert(demo);
        logger.info("插入操作-受影响的行数：{}", insertCount);
        logger.info("插入操作-添加的Demo：{}",demo);
    }

    @Test
    public void testDelete() throws Exception {
        Demo demo = new Demo();
        demo.setName("测试删除Demo");
        demo.setOpreateTime(new Date());
        int insertCount = demoDao.insert(demo);
        logger.info("删除前先插入数据-插入操作-受影响的行数：{}", insertCount);
        logger.info("删除前先插入数据-插入操作-添加的Demo：{}",demo);
        int deleteCount = demoDao.delete(demo.getId());
        logger.info("删除操作-受影响的行数：{}", deleteCount);
    }

    @Test
    public void testSelect() throws Exception {
        Demo demo = new Demo();
        demo.setName("测试添加Demo");
        demo.setOpreateTime(new Date());
        int insertCount = demoDao.insert(demo);
        logger.info("获取操作前先插入数据-插入操作-受影响的行数：{}", insertCount);
        logger.info("获取操作前先插入数据-插入操作-添加的Demo：{}",demo);
        Demo insertDemo = demoDao.select(demo.getId());
        logger.info("获取操作-获取的Demo：{}",insertDemo);
    }

    @Test
    public void testUpdate() throws Exception {
        Demo demo = new Demo();
        demo.setName("测试添加Demo");
        demo.setOpreateTime(new Date());
        int insertCount = demoDao.insert(demo);
        logger.info("更新操作前先插入数据-插入操作-受影响的行数：{}", insertCount);
        logger.info("更新操作前先插入数据-插入操作-添加的Demo：{}",demo);
        demo.setName("测试更新Demo");
        demo.setOpreateTime(new Date());
        int updateCount = demoDao.update(demo);
        logger.info("更新操作-受影响的行数：{}", updateCount);
    }
}