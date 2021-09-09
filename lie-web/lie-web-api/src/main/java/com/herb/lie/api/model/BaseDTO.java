package com.herb.lie.api.model;


import com.herb.lie.api.enums.ValidFlagEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author 54350
 */
@Data
public class BaseDTO {

    private Integer id;

    private String tmp1;

    private String tmp2;

    private Date createDate;

    private Date updateDate;

    private ValidFlagEnum validFlag;


    public Integer getId() {
        return id;
    }
}
