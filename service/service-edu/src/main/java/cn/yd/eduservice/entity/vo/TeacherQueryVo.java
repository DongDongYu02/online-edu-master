package cn.yd.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TeacherQueryVo {

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "讲师加入时间-开始")
    private String beginCreateTime;

    @ApiModelProperty(value = "讲师加入时间-结束")
    private String endCreateTime;

}
