package com.jsfspring.curddemo.uito;

import java.io.Serializable;
import java.util.List;

public class CategoryUITO implements Serializable {



	private static final long serialVersionUID = 1L;
	private Long catId;
	private String catName;

	private List<BookUITO> bookUITOLst;

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

	public List<BookUITO> getBookUITOLst() {
		return bookUITOLst;
	}

	public void setBookUITOLst(List<BookUITO> bookUITOLst) {
		this.bookUITOLst = bookUITOLst;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catId == null) ? 0 : catId.hashCode());
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
		CategoryUITO other = (CategoryUITO) obj;
		if (catId == null) {
			if (other.catId != null)
				return false;
		} else if (!catId.equals(other.catId))
			return false;
		return true;
	}

}
