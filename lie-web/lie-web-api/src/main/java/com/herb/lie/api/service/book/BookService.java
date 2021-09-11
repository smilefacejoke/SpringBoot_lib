package com.herb.lie.api.service.book;

import com.herb.lie.api.constants.ResultDTO;
import com.herb.lie.api.model.book.BookDTO;

/**
 * @author 54350
 */
public interface BookService {

    /**
     * 根据名称模糊查询全部书籍信息
     * @param name 分类名称
     * @return 匹配的数据集
     */
    ResultDTO findListByName(String name);

    /**
     * 根据id查找数据
     * @param id 主键
     * @return 查找的数据集
     */
    ResultDTO findById(int id);

    /**
     * 新增
     * @param entity 实体类（不包含id）
     * @return 影响的行数
     */
    ResultDTO insert(BookDTO entity);

    /**
     * 更新
     * @param entity 实体类（包含id）
     * @return
     */
    ResultDTO update(BookDTO entity);


    /**
     * 删除
     * @param  id 数据主键
     * @return 影响的行数
     */
    ResultDTO delete(int id);

}
