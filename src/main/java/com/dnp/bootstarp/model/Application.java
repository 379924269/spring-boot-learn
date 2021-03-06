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
 * 应用信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@XmlRootElement(name = "application" )
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "application" , description = "应用信息" )
public class Application extends Model<Application> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id" , type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "id" , dataType = "Integer" )
    private Integer id;
    /**
     * 应用名称
     */

    @XmlAttribute
    @ApiModelProperty(value = "应用名称" , dataType = "String" )
    private String name;
    /**
     * 应用版本名称
     */
    @TableField("version_name" )

    @XmlAttribute
    @ApiModelProperty(value = "应用版本名称" , dataType = "String" )
    private String versionName;
    /**
     * 应用版本号
     */
    @TableField("version_code" )

    @XmlAttribute
    @ApiModelProperty(value = "应用版本号" , dataType = "Integer" )
    private Integer versionCode;
    /**
     * 应用报名
     */
    @TableField("package_name" )

    @XmlAttribute
    @ApiModelProperty(value = "应用报名" , dataType = "String" )
    private String packageName;
    /**
     * 应用版本：如：华为、中心等（包名相同不同版本）
     */

    @XmlAttribute
    @ApiModelProperty(value = "应用版本：如：华为、中心等（包名相同不同版本）" , dataType = "String" )
    private String system;
    /**
     * 应用MD5
     */

    @XmlAttribute
    @ApiModelProperty(value = "应用MD5" , dataType = "String" )
    private String md5;
    /**
     * 应用大小
     */

    @XmlAttribute
    @ApiModelProperty(value = "应用大小" , dataType = "Integer" )
    private Integer size;
    /**
     * 应用地址
     */

    @XmlAttribute
    @ApiModelProperty(value = "应用地址" , dataType = "String" )
    private String url;
    /**
     * 创建时间
     */
    @TableField("created_date" )

    @XmlAttribute
    @ApiModelProperty(value = "创建时间" , dataType = "Long" )
    private Long createdDate;
    /**
     * 应用描述
     */

    @XmlAttribute
    @ApiModelProperty(value = "应用描述" , dataType = "String" )
    private String description;

    @TableField(exist = false)
    @XmlAttribute
    @ApiModelProperty(value = "不是数据库字段" , dataType = "String" )
    private String huazai;


    public Application() {
    }


    public Application(
            String name
            ,
            String versionName
            ,
            Integer versionCode
            ,
            String packageName
            ,
            String system
            ,
            String md5
            ,
            Integer size
            ,
            String url
            ,
            Long createdDate
            ,
            String description
    ) {
        this.name = name;
        this.versionName = versionName;
        this.versionCode = versionCode;
        this.packageName = packageName;
        this.system = system;
        this.md5 = md5;
        this.size = size;
        this.url = url;
        this.createdDate = createdDate;
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

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHuazai() {
        return huazai;
    }

    public void setHuazai(String huazai) {
        this.huazai = huazai;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", name=" + name +
                ", versionName=" + versionName +
                ", versionCode=" + versionCode +
                ", packageName=" + packageName +
                ", system=" + system +
                ", md5=" + md5 +
                ", size=" + size +
                ", url=" + url +
                ", createdDate=" + createdDate +
                ", description=" + description +
                "}";
    }
}
