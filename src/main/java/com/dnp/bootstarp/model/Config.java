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
 * 配置信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@XmlRootElement(name = "config" )
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "config" , description = "配置信息" )
public class Config extends Model<Config> {

    private static final long serialVersionUID = 1L;

    /**
     * 配置id
     */
    @TableId(value = "id" , type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "配置id" , dataType = "Integer" )
    private Integer id;
    /**
     * 配置名称
     */

    @XmlAttribute
    @ApiModelProperty(value = "配置名称" , dataType = "String" )
    private String name;
    /**
     * 配置内容,JSON字符串
     */

    @XmlAttribute
    @ApiModelProperty(value = "配置内容,JSON字符串" , dataType = "String" )
    private String content;
    /**
     * 配置创建时间
     */
    @TableField("created_date" )

    @XmlAttribute
    @ApiModelProperty(value = "配置创建时间" , dataType = "Long" )
    private Long createdDate;
    /**
     * 归属地id
     */
    @TableField("location_id" )

    @XmlAttribute
    @ApiModelProperty(value = "归属地id" , dataType = "Integer" )
    private Integer locationId;
    /**
     * 型号id
     */
    @TableField("model_id" )

    @XmlAttribute
    @ApiModelProperty(value = "型号id" , dataType = "Integer" )
    private Integer modelId;


    public Config() {
    }


    public Config(
            String name
            ,
            String content
            ,
            Long createdDate
            ,
            Integer locationId
            ,
            Integer modelId
    ) {
        this.name = name;
        this.content = content;
        this.createdDate = createdDate;
        this.locationId = locationId;
        this.modelId = modelId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", name=" + name +
                ", content=" + content +
                ", createdDate=" + createdDate +
                ", locationId=" + locationId +
                ", modelId=" + modelId +
                "}";
    }
}
