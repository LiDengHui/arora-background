package com.aurora.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ZoneEnum {
    SHANG_HAI("Asia/Shanghai", "中国上海");

    private final String zone;

    private final String desc;
}
