package com.herb.lie;

import com.herb.lie.api.constants.ResultDTO;
import com.herb.lie.api.enums.HttpCode;
import com.herb.lie.api.model.borrow.BookBorrowDTO;
import com.herb.lie.api.service.reback.RebackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 54350
 */
@RestController
@RequestMapping("/reback")
public class RebackController {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RebackService rebackService;

    @RequestMapping("doBack")
    public ResultDTO rebackBook(@RequestBody BookBorrowDTO bookBorrowDTO){
        try {
            return rebackService.updateBorrowInfo(bookBorrowDTO);
        }catch (Exception e){
            logger.error("系统异常+"+e);
            return new ResultDTO(HttpCode.ERROR.getCode(),"系统异常");
        }
    }

}
