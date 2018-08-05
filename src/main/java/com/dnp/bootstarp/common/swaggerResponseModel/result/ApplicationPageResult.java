package com.dnp.bootstarp.common.swaggerResponseModel.result;

import com.dnp.bootstarp.model.Application;
import io.swagger.annotations.ApiModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "applicationPageResult")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "app设备返回值", description = "app设备返回值")
public class ApplicationPageResult extends BasePageResult<Application>  implements Serializable {


}
