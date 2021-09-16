package com.herb.lie.dao.mapper.borrow;


import com.herb.lie.api.model.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

/**借书还书接口层
 * @author 54350
 */

@Mapper
public interface BookBorrowMapper {


    int insert(BookBorrowDTO bookBorrowDTO);
}
