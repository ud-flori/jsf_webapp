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
import com.jsfspring.curddemo.entity.BookDTO;
import com.jsfspring.curddemo.repositry.BooksRepo;
import com.jsfspring.curddemo.service.BooksService;
import com.jsfspring.curddemo.uito.BookUITO;

@Service
@Transactional
public class BooksServiceImpl implements BooksService {
	@Autowired
	BooksRepo booksRepo;

	@Override
	@Transactional(readOnly = false)
	public BookUITO doSaveBook(BookUITO bookUiTO) {
		BookDTO dto = UiToToDto(bookUiTO);
		dto = booksRepo.save(dto);
		BeanUtils.copyProperties(dto, bookUiTO);

		dtoToUito(bookUiTO, dto);
		return bookUiTO;
	}

	private void dtoToUito(BookUITO bookUiTO, BookDTO dto) {
		CategoryUITO uitTO = new CategoryUITO();
		BeanUtils.copyProperties(dto.getCategoryDTO(), uitTO);
		bookUiTO.setCategoryUITO(uitTO);
	}

	private BookDTO UiToToDto(BookUITO bookUiTO) {
		BookDTO dto = new BookDTO();
		CategoryDTO BookDto = new CategoryDTO();
		BeanUtils.copyProperties(bookUiTO, dto);
		BeanUtils.copyProperties(bookUiTO.getCategoryUITO(), BookDto);
		dto.setCategoryDTO(BookDto);
		List<BookDTO> lst = new ArrayList<>();
		lst.add(dto);
		BookDto.getBooktolst().addAll(lst);
		return dto;
	}

	@Override
	public List<BookUITO> doFetchAllBook() {
		List<BookDTO> dtoLst = booksRepo.findAll();
		List<BookUITO> uiTOLst = new ArrayList<>();
		dtoLst.forEach(dto -> {
			BookUITO tmpUiTO = new BookUITO();
			System.out.println(dto.getCategoryDTO());
			BeanUtils.copyProperties(dto, tmpUiTO);

			dtoToUito(tmpUiTO, dto);
			uiTOLst.add(tmpUiTO);
		});
		return uiTOLst;
	}

	@Override
	public BookUITO doGetBook(BookUITO bookUiTO) {
		if (null != bookUiTO.getWriter()) {
			BookDTO dto = new BookDTO();

			BeanUtils.copyProperties(bookUiTO, dto);
			dto = booksRepo.getOne(dto.getBookId());

			BeanUtils.copyProperties(dto, bookUiTO);
		}
		return bookUiTO;
	}

	@Override
	@Transactional
	public void doDeleteBook(BookUITO bookUiTO) {

		booksRepo.deleteById(bookUiTO.getBookId());
	}

}