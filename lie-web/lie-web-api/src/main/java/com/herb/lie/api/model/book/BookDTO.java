package com.herb.lie.api.model.book;

import com.herb.lie.api.model.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 54350
 * 书籍实体类
 */

@Data
public class BookDTO extends BaseDTO {

    private String bookName;

    private Integer bookClassId;

    private BigDecimal bookPrice;

    private Integer bookCount;

    private String bookPublish;

    private String bookAuthor;

    private String bookImg;

    private Date publishDate;


    public void setBookClassId(Integer bookClassId) {
        this.bookClassId = bookClassId;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookClassId() { return bookClassId; }

    public void setBookClassId(int bookClassId) {
        this.bookClassId = bookClassId;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getBookName() {
        return bookName;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "bookName='" + bookName + '\'' +
                ", bookClassId=" + bookClassId +
                ", bookPrice=" + bookPrice +
                ", bookCount=" + bookCount +
                ", bookPublish='" + bookPublish + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookImg='" + bookImg + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
