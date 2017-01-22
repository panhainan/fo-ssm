package com.panhainan.entity;

import java.util.Date;

/**
 * 测试案例：POJO类Demo
 * @author panhainan
 * @email panhainan@yeah.net
 * @version 1.0
 *
 */
public class Demo {
    private int id;
    private String name;
    private Date opreateTime;

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", opreateTime=" + opreateTime +
                '}';
    }

    public Demo() {
    }

    public Demo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOpreateTime() {
        return opreateTime;
    }

    public void setOpreateTime(Date opreateTime) {
        this.opreateTime = opreateTime;
    }
}
