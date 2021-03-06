package com.herb.lie;

import com.herb.lie.api.constants.ResultDTO;
import com.herb.lie.api.enums.HttpCode;
import com.herb.lie.api.model.book.BookClassDTO;
import com.herb.lie.api.service.book.BookClassService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 书籍分类访问层
 * @author zwt
 */

@RestController
@RequestMapping("/bookClass")
public class BookClassController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BookClassService bookClassService;

    /**
     * 根据名称寻找分类信息
     * @param bookClassDTO 分类名
     */
    @RequestMapping("/findListByName")
    public ResultDTO findByListName(@RequestBody BookClassDTO bookClassDTO){
        try {
            return bookClassService.findListByName(bookClassDTO.getName());
        }catch (Exception e){
            logger.error("系统异常+"+e);
            return new ResultDTO(HttpCode.ERROR.getCode(),"系统异常");
        }
    }

    /**
     * 根据id查找数据
     * @param bookClassDTO 数据主键
     */
    @RequestMapping("/findById")
    public ResultDTO findById(@RequestBody BookClassDTO bookClassDTO){
        try {
            return bookClassService.findById(bookClassDTO.getId());
        }catch (Exception e){
            logger.error("系统异常+"+e);
            e.printStackTrace();
            return new ResultDTO(HttpCode.ERROR.getCode(),"系统异常");
        }
    }

    /**
     * 新增数据
     * @param bookClassDTO
     */
    @RequestMapping("/insert")
    public ResultDTO insert(BookClassDTO bookClassDTO){
        try {
            return bookClassService.insert(bookClassDTO);
        }catch (Exception e){
            logger.error("系统异常+"+e);
            e.printStackTrace();
            return new ResultDTO(HttpCode.ERROR.getCode(),"系统异常");
        }
    }

    /**
     * 更新实体
     * @param bookClassDTO
     */
    @RequestMapping("/update")
    public ResultDTO update(BookClassDTO bookClassDTO){
        try {
            return bookClassService.update(bookClassDTO);
        }catch (Exception e){
            logger.error("系统异常+"+e);
            return new ResultDTO(HttpCode.ERROR.getCode(),"系统异常");
        }
    }

    /**
     * 根据id主键删除
     * @param bookClassDTO
     * @return
     */
    @RequestMapping("/delete")
    public ResultDTO delete(@RequestBody BookClassDTO bookClassDTO){
        try {
            return bookClassService.delete(bookClassDTO.getId());
        }catch (Exception e){
            logger.error("系统异常+"+e);
            return new ResultDTO(HttpCode.ERROR.getCode(),"系统异常");
        }
    }
}
