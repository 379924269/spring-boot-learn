package com.dnp.bootstarp.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;

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
 * 角色信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@XmlRootElement(name = "role" )
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "role" , description = "角色信息" )
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @TableId(value = "id" , type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "角色id" , dataType = "Integer" )
    private Integer id;
    /**
     * 角色名称
     */

    @XmlAttribute
    @ApiModelProperty(value = "角色名称" , dataType = "String" )
    private String name;
    /**
     * 角色描述
     */

    @XmlAttribute
    @ApiModelProperty(value = "角色描述" , dataType = "String" )
    private String description;


    public Role() {
    }


    public Role(
            String name
            ,
            String description
    ) {
        this.name = name;
        this.description = description;
    }


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                "}";
    }
}
