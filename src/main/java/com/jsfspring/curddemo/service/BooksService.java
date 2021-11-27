
package com.jsfspring.curddemo.service;

import java.util.List;

import com.jsfspring.curddemo.uito.BookUITO;

public interface BooksService {
	BookUITO doSaveBook(BookUITO bookUiTO);

	List<BookUITO> doFetchAllBook();

	BookUITO doGetBook(BookUITO bookUiTO);

	void doDeleteBook(BookUITO bookUiTO);
}