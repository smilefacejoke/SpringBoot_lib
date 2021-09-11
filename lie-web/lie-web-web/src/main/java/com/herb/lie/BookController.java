package com.herb.lie;

import com.herb.lie.api.constants.ResultDTO;
import com.herb.lie.api.enums.HttpCode;
import com.herb.lie.api.model.book.BookDTO;
import com.herb.lie.api.service.book.BookService;
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
@RequestMapping("/book")
public class BookController {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    /**
     * 根据名称寻找书籍信息
     * @param name 分类名
     */
    @RequestMapping("/findListByName")
    public ResultDTO findByListName(String name){
        try {
            return bookService.findListByName(name);
        }catch (Exception e){
            logger.error("系统异常+"+e);
            return new ResultDTO(HttpCode.ERROR.getCode(),"系统异常");
        }
    }

    /**
     * 根据id查找数据
     * @param id 数据主键
     */
    @RequestMapping("/findById")
    public ResultDTO findById(int id){
        try {
            return bookService.findById(id);
        }catch (Exception e){
            logger.error("系统异常+"+e);
            return new ResultDTO(HttpCode.ERROR.getCode(),"系统异常");
        }
    }

    /**
     * 新增数据
     * @param bookDTO
     */
    @RequestMapping("/insert")
    public ResultDTO insert(@RequestBody BookDTO bookDTO){
        try {
            return bookService.insert(bookDTO);
        }catch (Exception e){
            logger.error("系统异常+"+e);
            e.printStackTrace();
            return new ResultDTO(HttpCode.ERROR.getCode(),"系统异常");
        }
    }

    /**
     * 更新实体
     * @param bookDTO
     */
    @RequestMapping("/update")
    public ResultDTO update(@RequestBody BookDTO bookDTO) {
        try {
            return bookService.update(bookDTO);
        }catch (Exception e){
            logger.error("系统异常+"+e);
            e.printStackTrace();
            return new ResultDTO(HttpCode.ERROR.getCode(),"系统异常");
        }
    }

    /**
     * 根据id主键删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public ResultDTO delete(int id){
        try {
            return bookService.delete(id);
        }catch (Exception e){
            logger.error("系统异常+"+e);
            return new ResultDTO(HttpCode.ERROR.getCode(),"系统异常");
        }
    }

}
