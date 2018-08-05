package com.dnp.bootstarp.common.swaggerResponseModel.result;

import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页返回结果
 *
 * @Author 华仔
 * @DATE 2018/8/4 13:41
 */
public class BasePageResult<T> implements Serializable {
    @XmlElement(name = "total")
    @ApiModelProperty(value = "列总条数", dataType = "Integer", required = false)
    private int total;
    @XmlElement(name = "rows")
    @ApiModelProperty(value = "分页后详细信息", dataType = "list", required = false)
    private List<T> rows = new ArrayList<>();

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
