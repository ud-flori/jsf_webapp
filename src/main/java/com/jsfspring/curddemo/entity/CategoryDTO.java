package com.jsfspring.curddemo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "CATEGORIES")
public class CategoryDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CATEGORY_ID")
	private Long catId;
	@Column(name = "CATEGORY_NAME")
	private String catName;

	@OneToMany(mappedBy = "categoryDTO")
	private List<BookDTO> booktolst;

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public List<BookDTO> getBooktolst() {
		if (null == booktolst) {
			booktolst = new ArrayList<>();
		}
		return booktolst;
	}

	public void setBooktolst(List<BookDTO> booktolst) {
		this.booktolst = booktolst;
	}
}
