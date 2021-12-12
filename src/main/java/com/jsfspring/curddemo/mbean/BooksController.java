/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.curddemo.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import com.jsfspring.curddemo.uito.CategoryUITO;
import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.jsfspring.curddemo.service.CategoryService;
import com.jsfspring.curddemo.service.BooksService;
import com.jsfspring.curddemo.uito.BookUITO;

@Controller("bookController")
@SessionScope
public class BooksController {
	@Autowired
	private BooksService booksService;

	@Autowired
	private CategoryService categoryService;

	private String actionLabel;
	private BookUITO bookUiTO;
	private List<BookUITO> bookUiToList;

	private List<CategoryUITO> categoryUiToList;

	public void doSaveInfoBook() {
		System.out.println(this.getBookUiTO());
		booksService.doSaveBook(this.getBookUiTO());
		getAllBook();
		this.setBookUiTO(new BookUITO());
		RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Book Details", "Book added/Updated Successfully."));

	}

	@PostConstruct
	public void getAllBook() {
		if (!this.getBookUiToList().isEmpty()) {
			this.getBookUiToList().clear();
			this.getCategoryUiToList().clear();
		}
		System.out.println(" >>>>>>>>>>>>> " + booksService);
		this.getBookUiToList().addAll(booksService.doFetchAllBook());
		this.getCategoryUiToList().addAll(categoryService.getAllCategory());
		this.setActionLabel("Add");
	}


	public void deleteBook(BookUITO bookUiTO) {
		booksService.doDeleteBook(bookUiTO);
		getAllBook();
	}

	public void editBook(BookUITO bookUiTO) {
		this.setActionLabel("Update");
		BeanUtils.copyProperties(bookUiTO, this.getBookUiTO());
		System.out.println(this.getBookUiTO());
	}

	public BookUITO getBookUiTO() {
		if (bookUiTO == null) {
			bookUiTO = new BookUITO();
		}
		return bookUiTO;
	}

	public void setBookUiTO(BookUITO bookUiTO) {
		this.bookUiTO = bookUiTO;
	}

	public List<BookUITO> getBookUiToList() {
		if (null == bookUiToList) {
			bookUiToList = new ArrayList<>();
		}
		return bookUiToList;
	}

	public String getActionLabel() {
		return actionLabel;
	}

	public void setActionLabel(String actionLabel) {
		this.actionLabel = actionLabel;
	}

	public List<CategoryUITO> getCategoryUiToList() {
		if (categoryUiToList == null) {
			categoryUiToList = new ArrayList<>();
		}
		return categoryUiToList;
	}

	public void setCategoryUiToList(List<CategoryUITO> categoryUiToList) {
		this.categoryUiToList = categoryUiToList;
	}
}