package com.epam.idea.task.six.specification.search;

import com.epam.idea.task.six.model.Book;

import java.util.List;

public abstract class AbstractSearch<T> implements SearchSpecification<T> {
    @Override
    public Book find(List<Book> books, T value) {
        Book searchedBook = null;
        for (Book book : books) {
            T field = getField(book);
            if (field.toString().equalsIgnoreCase(value.toString())) {
                searchedBook = book;
            }
        }
        return searchedBook;
    }

    abstract T getField(Book book);
}
