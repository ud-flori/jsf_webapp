
package com.jsfspring.curddemo.service;

import java.util.List;

import com.jsfspring.curddemo.uito.CategoryUITO;

public interface CategoryService {

	List<CategoryUITO> getAllCategory();

	CategoryUITO getCategory(CategoryUITO categoryUITO);

}