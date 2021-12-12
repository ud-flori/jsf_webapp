package com.jsfspring.curddemo.utills;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.jsfspring.curddemo.uito.CategoryUITO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsfspring.curddemo.service.CategoryService;

@Service
public class DeptConverter implements Converter {

	@Autowired
	private CategoryService categoryService;

	private static final Logger LOG = LoggerFactory.getLogger(DeptConverter.class.getName());

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		LOG.info("getAsObject: " + categoryService);

		CategoryUITO categoryUITO = new CategoryUITO();
		categoryUITO.setCatName(string);
		categoryUITO = categoryService.getCategory(categoryUITO);
		System.out.println(categoryUITO.toString());
		return categoryUITO;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
		LOG.info("getAsString obj class: " + obj.getClass().getName());
		if (obj instanceof CategoryUITO) {
			CategoryUITO dept = (CategoryUITO) obj;
			LOG.info("getAsString def name: " + dept.getCatName());
			return dept.getCatName();
		} else {
			StringBuilder sbError = new StringBuilder("The object of class ");
			sbError.append(obj.getClass().getName()).append(" is not of CategoryUITO");
			throw new ClassCastException(sbError.toString());
		}
	}
}