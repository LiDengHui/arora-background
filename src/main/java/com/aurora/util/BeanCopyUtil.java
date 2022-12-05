package com.aurora.util;

import org.springframework.beans.BeanUtils;

public class BeanCopyUtil {

    public static <T> T copyObject(Object source, Class<T> target) {
        T temp = null;
        try {
            temp = target.newInstance();

            if(null!= source) {
                BeanUtils.copyProperties(source, temp);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return temp;
    }
}
