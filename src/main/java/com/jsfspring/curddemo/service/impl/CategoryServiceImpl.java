/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.curddemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jsfspring.curddemo.uito.CategoryUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsfspring.curddemo.entity.CategoryDTO;
import com.jsfspring.curddemo.repositry.CategoryRepo;
import com.jsfspring.curddemo.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public List<CategoryUITO> getAllCategory() {
		List<CategoryUITO> categoryUITOLst = new ArrayList<>();
		List<CategoryDTO> categoryDTOLst = categoryRepo.findAll();

		categoryDTOLst.forEach(dto -> {
			CategoryUITO tmpUiTO = new CategoryUITO();

			BeanUtils.copyProperties(dto, tmpUiTO);
			categoryUITOLst.add(tmpUiTO);
		});

		return categoryUITOLst;
	}

	@Override
	public CategoryUITO getCategory(CategoryUITO categoryUITO) {
		System.out.println(">>>>> "+ categoryUITO.getCatName());
		CategoryDTO dto = categoryRepo.findTitleByCatName(categoryUITO.getCatName());
		CategoryUITO uito = new CategoryUITO();

		BeanUtils.copyProperties(dto, uito);
		return uito;
	}
}