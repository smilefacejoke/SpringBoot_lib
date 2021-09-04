package com.herb.lie.api.model.book;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 54350
 * 书籍实体类
 */

@Data
public class BookDTO extends BaseDTO implements Serializable {

    private int id;

    private String bookName;

    private int bookClassId;

    private BigDecimal bookPrice;

    private String bookPublish;

    private String bookImg;

    private Date publishDate;


}
