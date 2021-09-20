package com.herb.lie.dao.mapper.reback;


import com.herb.lie.api.model.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

/**借书还书接口层
 * @author 54350
 */

@Mapper
public interface RebackMapper {

    /**
     * 更新借书数据
     * @param bookBorrowDTO
     * @return
     */
    int updateBorrowInfo(BookBorrowDTO bookBorrowDTO);

}
