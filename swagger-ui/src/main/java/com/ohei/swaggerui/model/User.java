package com.ohei.swaggerui.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户id")
    private Integer id;

    /**
     * 姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 年龄
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 账户余额
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "余额")
    private Double money;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", money=").append(money);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}