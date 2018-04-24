package com.dnp.bootstarp.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.util.Date;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * 操作日志
 * </p>
 *
 * @author huazai
 * @since 2018-04-24
 */
@TableName("operate_log")
@XmlRootElement(name = "operateLog")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "operateLog", description = "操作日志")
public class OperateLog extends Model<OperateLog> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "", dataType = "Integer")
    private Integer id;
    /**
     * 日志类型,1：正常日志，2：异常日志
     */
    @TableField("log_type")

    @XmlAttribute
    @ApiModelProperty(value = "日志类型,1：正常日志，2：异常日志", dataType = "Integer")
    private Integer logType;
    /**
     * 创建日期
     */
    @TableField("created_date")

    @XmlAttribute
    @ApiModelProperty(value = "创建日期", dataType = "Date")
    private Date createdDate;
    /**
     * 产生日志用户id
     */
    @TableField("user_id")

    @XmlAttribute
    @ApiModelProperty(value = "产生日志用户id", dataType = "Integer")
    private Integer userId;
    /**
     * 产生日志用户email
     */
    @TableField("user_email")

    @XmlAttribute
    @ApiModelProperty(value = "产生日志用户email", dataType = "String")
    private String userEmail;
    /**
     * 日志描述
     */

    @XmlAttribute
    @ApiModelProperty(value = "日志描述", dataType = "String")
    private String description;
    /**
     * 产生日志IP地址
     */

    @XmlAttribute
    @ApiModelProperty(value = "产生日志IP地址", dataType = "String")
    private String ip;


    public OperateLog() {
    }


    public OperateLog(
            Integer logType
            ,
            Date createdDate
            ,
            Integer userId
            ,
            String userEmail
            ,
            String description
            ,
            String ip
    ) {
        this.logType = logType;
        this.createdDate = createdDate;
        this.userId = userId;
        this.userEmail = userEmail;
        this.description = description;
        this.ip = ip;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OperateLog{" +
                "id=" + id +
                ", logType=" + logType +
                ", createdDate=" + createdDate +
                ", userId=" + userId +
                ", userEmail=" + userEmail +
                ", description=" + description +
                ", ip=" + ip +
                "}";
    }
}
