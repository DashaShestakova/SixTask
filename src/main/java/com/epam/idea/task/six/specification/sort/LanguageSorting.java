package com.epam.idea.task.six.specification.sort;

import com.epam.idea.task.six.model.Book;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LanguageSorting implements Comparator<Book>,SortingSpecification {
    @Override
    public int compare(Book bookOne, Book bookTwo) {
        if (bookOne == null) {
            if (bookTwo == null) {
                return 0;
            }
            return -1;
        } else if (bookTwo == null) {
            return 1;
        }
        return bookOne.getLanguage().compareTo(bookTwo.getLanguage());
    }

    @Override
    public void sort(List books) {
        Collections.sort(books , new LanguageSorting());
    }
}
