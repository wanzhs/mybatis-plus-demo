package com.ga.mybatis.plus.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DriverPageVo {
    private int index;
    private int size;
    private Driver driver;
}
