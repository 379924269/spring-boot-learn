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
 * TF卡信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@XmlRootElement(name = "tfcard" )
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "tfcard" , description = "TF卡信息" )
public class Tfcard extends Model<Tfcard> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键代理id
     */
    @TableId(value = "id" , type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "主键代理id" , dataType = "Integer" )
    private Integer id;
    /**
     * tf卡id
     */
    @TableField("tf_id" )

    @XmlAttribute
    @ApiModelProperty(value = "tf卡id" , dataType = "String" )
    private String tfId;
    /**
     * tf卡的序列号
     */
    @TableField("tf_sn" )

    @XmlAttribute
    @ApiModelProperty(value = "tf卡的序列号" , dataType = "String" )
    private String tfSn;
    /**
     * -1:停用,0:未使用,1:使用
     */

    @XmlAttribute
    @ApiModelProperty(value = "-1:停用,0:未使用,1:使用" , dataType = "Integer" )
    private Integer status;
    /**
     * 归属地id
     */
    @TableField("location_id" )

    @XmlAttribute
    @ApiModelProperty(value = "归属地id" , dataType = "Integer" )
    private Integer locationId;
    /**
     * tf卡创建时间
     */
    @TableField("created_date" )

    @XmlAttribute
    @ApiModelProperty(value = "tf卡创建时间" , dataType = "Long" )
    private Long createdDate;


    public Tfcard() {
    }


    public Tfcard(
            String tfId
            ,
            String tfSn
            ,
            Integer status
            ,
            Integer locationId
            ,
            Long createdDate
    ) {
        this.tfId = tfId;
        this.tfSn = tfSn;
        this.status = status;
        this.locationId = locationId;
        this.createdDate = createdDate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTfId() {
        return tfId;
    }

    public void setTfId(String tfId) {
        this.tfId = tfId;
    }

    public String getTfSn() {
        return tfSn;
    }

    public void setTfSn(String tfSn) {
        this.tfSn = tfSn;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Tfcard{" +
                "id=" + id +
                ", tfId=" + tfId +
                ", tfSn=" + tfSn +
                ", status=" + status +
                ", locationId=" + locationId +
                ", createdDate=" + createdDate +
                "}";
    }
}
