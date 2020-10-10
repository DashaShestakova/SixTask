package com.epam.idea.task.six.specification.sort;

import com.epam.idea.task.six.model.Book;

import java.util.List;

public interface SortingSpecification<T> {
    void sort(List<Book> books);
}
