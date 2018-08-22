package com.ga.mybatis.plus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ga.mybatis.plus.entity.Driver;
import com.ga.mybatis.plus.entity.DriverPageVo;
import com.ga.mybatis.plus.service.IDriverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lq
 * @since 2018-08-22
 */
@Slf4j
@RestController
@RequestMapping("/driver")
public class DriverController {
    @Resource
    IDriverService driverService;

    @PostMapping("/add")
    public Driver add(@RequestBody Driver driver) {
        boolean isTrue=driverService.insert(driver);
        if(isTrue){
            log.info("新添加的ID,{}",driver.getId());
            return driver;
        }
        return null;
    }

    @PostMapping("/con")
    public String getByCon(@RequestBody Driver driver){
        QueryWrapper<Driver> wrapper=new QueryWrapper<>();
        wrapper.setEntity(driver);
        Driver rs= driverService.selectOne(wrapper);
        return rs.toString();
    }
    @PostMapping("/page")
    public IPage<Driver> getPageByCon(@RequestBody DriverPageVo vo){
        Page<Driver> page=new Page<>(vo.getIndex(),vo.getSize());
        QueryWrapper<Driver> wrapper=new QueryWrapper<>(vo.getDriver());
        IPage<Driver> iPage= driverService.selectPage(page,wrapper);
        return iPage;
    }

}

