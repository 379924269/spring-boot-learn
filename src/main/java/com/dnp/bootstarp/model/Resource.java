package com.dnp.bootstarp.model;

import com.baomidou.mybatisplus.annotations.TableField;
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
 * 资源权限信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@XmlRootElement(name = "resource" )
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "resource" , description = "资源权限信息" )
public class Resource extends Model<Resource> {

    private static final long serialVersionUID = 1L;

    /**
     * 资源id
     */
    @TableId(value = "id" , type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "资源id" , dataType = "Integer" )
    private Integer id;
    /**
     * 资源名称
     */

    @XmlAttribute
    @ApiModelProperty(value = "资源名称" , dataType = "String" )
    private String name;
    /**
     * 资源父节点
     */
    @TableField("parent_id" )

    @XmlAttribute
    @ApiModelProperty(value = "资源父节点" , dataType = "Integer" )
    private Integer parentId;
    /**
     * 资源key
     */
    @TableField("res_key" )

    @XmlAttribute
    @ApiModelProperty(value = "资源key" , dataType = "String" )
    private String resKey;
    /**
     * 资源value
     */
    @TableField("res_url" )

    @XmlAttribute
    @ApiModelProperty(value = "资源value" , dataType = "String" )
    private String resUrl;


    public Resource() {
    }


    public Resource(
            String name
            ,
            Integer parentId
            ,
            String resKey
            ,
            String resUrl
    ) {
        this.name = name;
        this.parentId = parentId;
        this.resKey = resKey;
        this.resUrl = resUrl;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getResKey() {
        return resKey;
    }

    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name=" + name +
                ", parentId=" + parentId +
                ", resKey=" + resKey +
                ", resUrl=" + resUrl +
                "}";
    }
}
