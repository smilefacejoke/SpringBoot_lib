package com.herb.lie.api.model.book;


import com.herb.lie.api.enums.ValidFlagEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author 54350
 */
@Data
public class BaseDTO {

    private int Id;

    private String tmp1;

    private String tmp2;

    private Date createDate;

    private Date updateDate;

    private ValidFlagEnum validFlag;

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

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
