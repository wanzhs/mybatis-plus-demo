package com.ga.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;


import com.baomidou.mybatisplus.core.enums.IEnum;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lq
 * @since 2018-08-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_driver")
public class Driver extends Model<Driver> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String code;
    private String name;
    private String phone;
    /**
     * 1-男性，2-女性，9-未知
     */
    private String gender;
    /**
     * 0有效，1无效   平台用户的状态
     */
    private State state;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }


    public enum  State implements IEnum<Integer>{
        ABLE(0,"有效"),
        DISABLE(1,"无效");
        private Integer value;
        private String desc;

        State(final Integer value,final String desc){
            this.value=value;
            this.desc=desc;
        }

        @Override
        @JsonValue
        public Integer getValue() {
            return this.value;
        }

        public String getDesc() {
            return desc;
        }
    }

}
