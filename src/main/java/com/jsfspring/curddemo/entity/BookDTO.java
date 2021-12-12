/**
 * 
 */
package com.jsfspring.curddemo.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "BOOKS")
@NamedQuery(name = "BookDTO.findAll", query = "SELECT a FROM BookDTO a")
public class BookDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long book_id;
	@Column(name = "BOOK_NAME", nullable = false)
	private String bookName;

	private String description;

	@Column(name = "WRITER")
	private String writer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID")
	private CategoryDTO categoryDTO;

	public Long getBookId() {
		return book_id;
	}

	public void setBookId(Long bookId) {
		this.book_id = bookId;
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

	public CategoryDTO getCategoryDTO() {

		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

}
