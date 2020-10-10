package com.epam.idea.task.six.specification.search;

import com.epam.idea.task.six.model.Book;

import java.util.List;

public interface SearchSpecification<T> {
    Book find(List<Book> books, T value);
}
