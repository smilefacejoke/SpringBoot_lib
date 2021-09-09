package com.herb.lie.api.model.book;

import com.herb.lie.api.model.BaseDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 54350
 */

@Data
public class BookClassDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 6109911930620603904L;


    /**
     * 分类名称
     */
    private String name;


    public String getName() {
        return name;
    }
}
