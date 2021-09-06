package com.herb.lie;

import com.herb.lie.api.constants.ResultDTO;
import com.herb.lie.api.enums.HttpCode;
import com.herb.lie.api.model.book.BookClassDTO;
import com.herb.lie.api.service.BookClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 书籍分类访问层
 * @author zwt
 */

@RestController
@RequestMapping("/bookClass")
public class BookClassController {

    @Autowired
    private BookClassService bookClassService;

    /**
     * 根据名称寻找分类信息
     * @param name 分类名
     */
    @RequestMapping("/findByName")
    public ResultDTO findByName(String name){
        try {
            return bookClassService.findListByName(name);
        }catch (Exception e){
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
            return bookClassService.findById(id);
        }catch (Exception e){
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
            return bookClassService.delete(id);
        }catch (Exception e){
            return new ResultDTO(HttpCode.ERROR.getCode(),"系统异常");
        }
    }
}
