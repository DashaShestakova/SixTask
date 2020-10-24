package com.epam.idea.task.six.data;

import com.epam.idea.task.six.exception.DaoException;
import com.epam.idea.task.six.model.Book;
import com.epam.idea.task.six.factory.Field;
import com.epam.idea.task.six.factory.search.SearchSpecification;
import com.epam.idea.task.six.factory.SearchSpecificationFactory;
import com.epam.idea.task.six.factory.SortingFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookDao {
    private List<Book> books = new ArrayList<>();

    /*public BookDao(List<Book> books) {
        this.books = books;
    }*/

    public void addBook(Book book) throws DaoException {
        if (!books.contains(book)) {
            books.add(book);
        } else {
            throw new DaoException("There is a book of this type in the list.");
        }
    }

    public void addBook(List<Book> books) throws DaoException {
        for (Book book : books) {
            if (!books.contains(book)) {
                books.add(book);
            } else {
                throw new DaoException("There is a book of this type in the list.");
            }
        }

    }

    public void removeBook(Book book) throws DaoException {
        if (books.contains(book)) {
            books.remove(book);
        } else {
            throw new DaoException("There is no book of this type in the List.");
        }
    }

    public <T> Book findByTag(Field field, T name) {
        SearchSpecificationFactory factory = new SearchSpecificationFactory();
        SearchSpecification specification = factory.create(field);
        return specification.find(books, name);
    }

    public List<Book> sortByTag(Field field) {
        SortingFactory sortingFactory = new SortingFactory();
        Comparator<Book> comparator = sortingFactory.create(field);
        Collections.sort(books, comparator);
        return books;
    }

    public int size() {
        return books.size();
    }
}
