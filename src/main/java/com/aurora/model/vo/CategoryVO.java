package com.aurora.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "分类")
public class CategoryVO {
    @ApiModelProperty(name="id", value="分类id", dataType="Integer")
    private Integer id;

    @ApiModelProperty(name="categoryName", value="分类名", dataType="String", required = true)
    private String categoryName;
}
