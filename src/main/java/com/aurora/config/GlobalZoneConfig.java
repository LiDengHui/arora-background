package com.aurora.config;

import com.aurora.enums.ZoneEnum;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Configuration
public class GlobalZoneConfig {

    @PostConstruct
    public void setGlobalZone() {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneEnum.SHANG_HAI.getZone()));
    }
}
