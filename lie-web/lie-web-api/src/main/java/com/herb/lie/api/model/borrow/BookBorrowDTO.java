package com.herb.lie.api.model.borrow;

import com.herb.lie.api.model.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 借书实体类
 * @author 54350
 */
public class BookBorrowDTO extends BaseDTO {

    private int userId;

    private String userName;

    private int bookId;

    private String bookName;

    private int count;

    private Date startDate;

    private Date endDate;  

    private BigDecimal price;

    private BigDecimal tradeFee;

    @Override
    public String toString() {
        return "BookBorrowDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", count=" + count +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", tradeFee=" + tradeFee +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTradeFee() {
        return tradeFee;
    }

    public void setTradeFee(BigDecimal tradeFee) {
        this.tradeFee = tradeFee;
    }
}
