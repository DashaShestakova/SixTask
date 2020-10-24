package com.epam.idea.task.six.factory.search;

import com.epam.idea.task.six.model.Book;


public class YearSearch extends AbstractSearch {

    @Override
    Integer getField(Book book) {
        return book.getYear();
    }
}
