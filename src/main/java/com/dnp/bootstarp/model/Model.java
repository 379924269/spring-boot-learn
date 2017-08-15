package com.dnp.bootstarp.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * <p>
 * 型号信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@XmlRootElement(name = "model" )
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "model" , description = "型号信息" )
public class Model extends com.baomidou.mybatisplus.activerecord.Model<Model> {

    private static final long serialVersionUID = 1L;

    /**
     * 型号id
     */
    @TableId(value = "id" , type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "型号id" , dataType = "Integer" )
    private Integer id;
    /**
     * 型号名称
     */

    @XmlAttribute
    @ApiModelProperty(value = "型号名称" , dataType = "String" )
    private String name;


    public Model() {
    }


    public Model(
            String name
    ) {
        this.name = name;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name=" + name +
                "}";
    }
}
