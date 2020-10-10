package com.epam.idea.task.six.specification.search;

import com.epam.idea.task.six.model.Book;

public class NumberOfPagesSearch extends AbstractSearch {

    @Override
    Integer getField(Book book) {
        return book.getNumberOfPages();
    }

}
