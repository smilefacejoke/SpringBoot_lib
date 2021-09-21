package com.herb.lie.api.service.reback;

import com.herb.lie.api.constants.ResultDTO;
import com.herb.lie.api.model.borrow.BookBorrowDTO;

public interface RebackService {

    /**
     * 更新借书信息
     * @param bookBorrowDTO
     * @return
     */
    ResultDTO updateBorrowInfo(BookBorrowDTO bookBorrowDTO);

}
