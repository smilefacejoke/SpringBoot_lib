package com.herb.lie.api.model.book;

import lombok.Data;

/**
 * @author 54350
 */

@Data
public class BookClassDTO extends BaseDTO {

    /**
     * 分类名称
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
