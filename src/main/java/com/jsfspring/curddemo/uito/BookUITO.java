/**
 * 
 */
package com.jsfspring.curddemo.uito;

import java.io.Serializable;

/**
 * @author s727953
 *
 */
public class BookUITO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4840260415183676656L;
	private Long bookId;
	private String bookName;
	private String description;
	private String writer;
	private CategoryUITO categoryUITO;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public CategoryUITO getCategoryUITO() {
		return categoryUITO;
	}

	public void setCategoryUITO(CategoryUITO categoryUITO) {
		this.categoryUITO = categoryUITO;
	}

	@Override
	public String toString() {
		return "BookUITO [bookId=" + bookId + ", bookName=" + bookName + ", description="
				+ description + ", writer=" + writer + ", categoryUITO=" + categoryUITO + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookUITO other = (BookUITO) obj;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		return true;
	}

}
