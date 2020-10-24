package com.epam.idea.task.six.factory.sort;

import com.epam.idea.task.six.model.Book;

import java.util.Comparator;

public class NumberOfPagesSorting implements Comparator<Book>{
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
        return bookOne.getNumberOfPages() - bookTwo.getNumberOfPages();
    }
}
