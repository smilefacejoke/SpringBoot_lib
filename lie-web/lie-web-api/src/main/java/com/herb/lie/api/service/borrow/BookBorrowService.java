package com.herb.lie.api.service.borrow;

import com.herb.lie.api.constants.ResultDTO;

import java.util.Date;

/**
 * @author 54350
 */
public interface BookBorrowService {

    /**
     * 借书操作
     * @param bookId
     * @param startDate
     * @param endDate
     * @param borrowCount
     * @param userId
     * @param userName
     * @param vipFlag
     * @return
     */
    ResultDTO doBorrow(int bookId, Date startDate, Date endDate, int borrowCount, int userId, String userName, boolean vipFlag);


}
