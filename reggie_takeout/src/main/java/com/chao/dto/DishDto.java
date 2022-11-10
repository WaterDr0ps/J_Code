package com.chao.dto;

import com.chao.entity.Dish;
import com.chao.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>DTO data transfer object 用于封装页面数据</p>
 * @author Eliot
 */
@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
