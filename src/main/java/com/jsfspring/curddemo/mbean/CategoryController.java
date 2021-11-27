package com.jsfspring.curddemo.mbean;

import com.jsfspring.curddemo.service.CategoryService;
import com.jsfspring.curddemo.uito.CategoryUITO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mates on 2020. 11. 05..
 */
@Controller("catController")
@SessionScope
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    public List<CategoryUITO> getCategoryUiToList() {
        return categoryUiToList;
    }

    public void setCategoryUiToList(List<CategoryUITO> categoryUiToList) {
        this.categoryUiToList = categoryUiToList;
    }

    private List<CategoryUITO> categoryUiToList;


    @PostConstruct
    public void getAllCategory() {
        categoryUiToList = new ArrayList<>();
        if (!this.getCategoryUiToList().isEmpty()) {
            this.getCategoryUiToList().clear();
        }
        this.getCategoryUiToList().addAll(categoryService.getAllCategory());
    }
}
