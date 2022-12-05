package com.aurora.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_resource")
public class Resource {
    private Integer id;

    private String resourceName;

    private String url;

    private String requestMethod;

    private Integer isDisabled;

    private Integer isAnonymous;

    private LocalDateTime createTime;

    private List<Resource> children;
}
