package com.herb.lie.service.reback;

import com.herb.lie.api.constants.ResultDTO;
import com.herb.lie.api.enums.HttpCode;
import com.herb.lie.api.enums.ValidFlagEnum;
import com.herb.lie.api.model.book.BookDTO;
import com.herb.lie.api.model.borrow.BookBorrowDTO;
import com.herb.lie.api.service.reback.RebackService;
import com.herb.lie.dao.mapper.book.BookMapper;
import com.herb.lie.dao.mapper.borrow.BookBorrowMapper;
import com.herb.lie.dao.mapper.reback.RebackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author 54350
 */
@Service
public class RebackServiceImpl implements RebackService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookBorrowMapper bookBorrowMapper;

    @Override
    public ResultDTO updateBorrowInfo(BookBorrowDTO bookBorrowDTO) {
        int bookId=bookBorrowDTO.getBookId();
        if(0>=bookId){
            return new ResultDTO(HttpCode.FAIL.getCode(),"书籍id不能为空");
        }
        if(0>=bookBorrowDTO.getId()){
            return new ResultDTO(HttpCode.FAIL.getCode(),"数据主键不能为空");
        }
        //1-查找本地是否存在这个书籍
        BookDTO bookDTO = bookMapper.findById(bookId);
        if(null==bookDTO){
            return new ResultDTO(HttpCode.FAIL.getCode(),"检测书籍不存在");
        }

        //2-本地借书信息查询
        BookBorrowDTO localBookBorrowDTO=bookBorrowMapper.findById(bookBorrowDTO.getId());
        if (null==localBookBorrowDTO){
            return new ResultDTO(HttpCode.FAIL.getCode(),"借书信息不存在，请确保信息合法或联系图书管理员");
        }

        //2-1本地借书的数量
        int borrowCount=localBookBorrowDTO.getCount();
        int tmp1Count=0;
        if(!StringUtils.isEmpty(localBookBorrowDTO.getTmp1())){
            tmp1Count=Integer.parseInt(localBookBorrowDTO.getTmp1());
        }

        if(tmp1Count==borrowCount){
            return new ResultDTO(HttpCode.FAIL.getCode(),"您已还完全部书籍，无需归还");
        }

        //2-2还书的数量
        int rebackCount=bookBorrowDTO.getCount();

        // 当归还数量不相等时，当前归还数量保存在tmp1字段
        return doReback(rebackCount, borrowCount-tmp1Count, localBookBorrowDTO, bookDTO);
    }

    /**
     * 真正的还书操作
     * @param rebackCount   还书数量
     * @param borrowCount   借书数量
     * @param localBookBorrowDTO    本地借书实体类
     * @param bookDTO   本地书籍实体类
     * @return
     */
    private ResultDTO doReback(int rebackCount, int borrowCount, BookBorrowDTO localBookBorrowDTO, BookDTO bookDTO) {
        if(rebackCount>borrowCount){
            return new ResultDTO(HttpCode.FAIL.getCode(),"归还数量大于借阅数量，请确保归还数量正常");
        }else if(rebackCount==borrowCount){
            //借书还书一样，数据DISABLE,book表数量增加
            //1，操作还书信息表
            localBookBorrowDTO.setCount(0);
            int nowTmpCount=0;
            if(!StringUtils.isEmpty(localBookBorrowDTO.getTmp1())){
                nowTmpCount=Integer.parseInt(localBookBorrowDTO.getTmp1());
            }
            localBookBorrowDTO.setTmp1(String.valueOf(rebackCount+nowTmpCount));
            localBookBorrowDTO.setTmp2(String.valueOf(new Date()));
            localBookBorrowDTO.setValidFlag(ValidFlagEnum.DISABLE);

            bookBorrowMapper.update(localBookBorrowDTO);

            //2.追加book信息表剩余数量
            bookDTO.setBookCount(bookDTO.getBookCount()+rebackCount);
            bookDTO.setUpdateDate(new Date());
            bookMapper.update(bookDTO);
        }else{
            //还书数量小于借书数量，更新还书信息（tmpl），同时更新book剩余数量
            int nowTmpCount=0;
            if(!StringUtils.isEmpty(localBookBorrowDTO.getTmp1())){
                nowTmpCount=Integer.parseInt(localBookBorrowDTO.getTmp1());
            }
            localBookBorrowDTO.setTmp1(String.valueOf(rebackCount+nowTmpCount ));
            localBookBorrowDTO.setTmp2(String.valueOf(new Date()));
             bookBorrowMapper.update(localBookBorrowDTO);

            //2.追加book信息表剩余数量
            bookDTO.setBookCount(bookDTO.getBookCount()+rebackCount);
            bookDTO.setUpdateDate(new Date());
            bookMapper.update(bookDTO);
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"归还成功,还有"+(borrowCount-rebackCount)+"本书没归还"+localBookBorrowDTO.getEndDate()+"之前归还剩余书籍");
    }


}
