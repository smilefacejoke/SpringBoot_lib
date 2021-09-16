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

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTmp1() {
        return tmp1;
    }

    public void setTmp1(String tmp1) {
        this.tmp1 = tmp1;
    }

    public String getTmp2() {
        return tmp2;
    }

    public void setTmp2(String tmp2) {
        this.tmp2 = tmp2;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public ValidFlagEnum getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(ValidFlagEnum validFlag) {
        this.validFlag = validFlag;
    }

    public Integer getId() {
        return id;
    }
}
