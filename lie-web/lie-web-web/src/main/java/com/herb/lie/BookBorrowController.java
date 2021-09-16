package com.herb.lie;

import com.alibaba.fastjson.JSONObject;
import com.herb.lie.api.constants.ResultDTO;
import com.herb.lie.api.enums.HttpCode;
import com.herb.lie.api.service.borrow.BookBorrowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 借书还书操作层
 * @author 54350
 */
@RestController
@RequestMapping("/borrow")
public class BookBorrowController {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookBorrowService bookBorrowService;

    @RequestMapping("/doBorrow")
    public ResultDTO doBorrow(@RequestBody JSONObject jsonParams){
        try {
            //个性化推荐用户默认喜欢的书籍（）

            //step1:非法校验
            //要借的书的编号
            int bookId=Integer.parseInt(String.valueOf(jsonParams.getOrDefault("bookId",0)));
            if(bookId<=0){
                return new ResultDTO(HttpCode.FAIL.getCode(),"书籍编号不合法，请选择所选的书籍是否存在！");
            }
            //租借起始截止日期（日期前后的非法校验交给前端来做)
            Date startDate=jsonParams.getDate("startDate");
            Date endDate=jsonParams.getDate("endDate");
            int borrowCount=jsonParams.getInteger("borrowCount");
            int userId=jsonParams.getInteger("userId");
            String userName=jsonParams.getString("userName");

            boolean vipFlag=jsonParams.getBoolean("vipFlag");

            return bookBorrowService.doBorrow(bookId,startDate,endDate,borrowCount,userId,userName,vipFlag);

        }catch (Exception e){
            logger.error("系统异常+"+e);
            return new ResultDTO(HttpCode.ERROR.getCode(),"系统异常");
        }
    }

}
