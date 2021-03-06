package com.herb.lie.service.borrow;

import com.herb.lie.api.constants.ResultDTO;
import com.herb.lie.api.enums.HttpCode;
import com.herb.lie.api.enums.ValidFlagEnum;
import com.herb.lie.api.model.book.BookDTO;
import com.herb.lie.api.model.borrow.BookBorrowDTO;
import com.herb.lie.api.service.borrow.BookBorrowService;
import com.herb.lie.dao.mapper.book.BookMapper;
import com.herb.lie.dao.mapper.borrow.BookBorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 借书逻辑处理层
 * @author 54350
 */

@Service
public class BookBorrowServiceImpl implements BookBorrowService {

    @Autowired
    private BookBorrowMapper bookBorrowMapper;

    @Autowired
    private BookMapper bookMapper;


    @Override
    public ResultDTO doBorrow(int bookId, Date startDate, Date endDate, int borrowCount, int userId, String userName, boolean vipFlag) {
        //step1:非法校验
        if(startDate.after(endDate)){
            return new ResultDTO(HttpCode.FAIL.getCode(),"起始日期不能晚于归还日期");
        }

        //step2:获取书籍
        if(borrowCount<=0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"借书数量应大于0");
        }
        BookDTO bookDTO=bookMapper.findById(bookId);
        //书籍存在性判断
        if(bookDTO==null){
            return new ResultDTO(HttpCode.FAIL.getCode(),"书籍不存在");
        }
        //书籍数量是否足够的校验
        int bookCount=bookDTO.getBookCount();
        if (bookCount<=0){
            // TODO 在查找书籍的时候如果返回的书籍数量为0，前端直接禁用租借按钮，同时增加一个效果：当前书籍已经租借完毕
            return new ResultDTO(HttpCode.FAIL.getCode(),"当前书籍已经租借完了，看看别的书吧");
        }
        if(borrowCount>bookCount){
            return new ResultDTO(HttpCode.FAIL.getCode(),"借书数量大于库存数量，当前剩余数量："+bookCount);
        }

        //step3:真正的借书操作
        int result=doInsertBookBorrowRecord( bookId,  bookDTO, startDate,  endDate,  borrowCount,  userId,  userName,  vipFlag);
        if(result<=0){
            //新增失败
            return new ResultDTO(HttpCode.FAIL.getCode(),"借书失败，你可以尝试重新借书，或者联系图书管理员");
        }

        //step4:减少书籍数量
        bookDTO.setBookCount(bookCount-borrowCount);
        bookDTO.setUpdateDate(new Date());
        bookMapper.update(bookDTO);

        return new ResultDTO(HttpCode.SUCCESS.getCode(),"借书成功");
    }

    private int doInsertBookBorrowRecord(int bookId, BookDTO bookDTO,Date startDate, Date endDate, int borrowCount, int userId, String userName, boolean vipFlag) {
        BookBorrowDTO bookBorrowDTO=new BookBorrowDTO();
        bookBorrowDTO.setBookId(bookId);
        bookBorrowDTO.setBookName(bookDTO.getBookName());
        bookBorrowDTO.setCount(borrowCount);
        bookBorrowDTO.setStartDate(startDate);
        bookBorrowDTO.setEndDate(endDate);
        //用户信息我们可以从session中获取:HttpSession session=request.getSession()
        bookBorrowDTO.setUserId(userId);
        bookBorrowDTO.setUserName(userName);
        //设置书籍价格
        BigDecimal bookPrice=bookDTO.getBookPrice();
        long day=(endDate.getTime()-startDate.getTime())/(24*60*60*1000);
        long totalPrice=bookPrice.intValue()*day;

        bookBorrowDTO.setPrice(new BigDecimal(totalPrice));
        bookBorrowDTO.setTradeFee(new BigDecimal(totalPrice));
        if(vipFlag){
            bookBorrowDTO.setTradeFee(new BigDecimal(0.0));
        }
        bookBorrowDTO.setCreateDate(new Date());
        bookBorrowDTO.setValidFlag(ValidFlagEnum.ENABLE);

        //新增
        int result=bookBorrowMapper.insert(bookBorrowDTO);
        return result;
    }
}
