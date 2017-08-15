package com.dnp.bootstarp.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
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
 * 资源角色关系信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@TableName("res_role" )
@XmlRootElement(name = "resRole" )
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "resRole" , description = "资源角色关系信息" )
public class ResRole extends Model<ResRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 资源角色关系id
     */
    @TableId(value = "id" , type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "资源角色关系id" , dataType = "Integer" )
    private Integer id;
    /**
     * 资源id
     */
    @TableField("resource_id" )

    @XmlAttribute
    @ApiModelProperty(value = "资源id" , dataType = "Integer" )
    private Integer resourceId;
    /**
     * 角色id
     */
    @TableField("role_id" )

    @XmlAttribute
    @ApiModelProperty(value = "角色id" , dataType = "Integer" )
    private Integer roleId;


    public ResRole() {
    }


    public ResRole(
            Integer resourceId
            ,
            Integer roleId
    ) {
        this.resourceId = resourceId;
        this.roleId = roleId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ResRole{" +
                "id=" + id +
                ", resourceId=" + resourceId +
                ", roleId=" + roleId +
                "}";
    }
}
