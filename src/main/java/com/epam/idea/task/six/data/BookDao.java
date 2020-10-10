package com.epam.idea.task.six.data;

import com.epam.idea.task.six.exception.DaoException;
import com.epam.idea.task.six.model.Book;
import com.epam.idea.task.six.specification.factory.Field;
import com.epam.idea.task.six.specification.search.SearchSpecification;
import com.epam.idea.task.six.specification.factory.SearchSpecificationFactory;
import com.epam.idea.task.six.specification.sort.SortingSpecification;
import com.epam.idea.task.six.specification.factory.SortingSpecificationFactory;

import java.util.List;
import java.util.Objects;

public class BookDao {
    private List<Book> books;
    private Book book;

    public BookDao(List<Book> books) {
        this.books = books;
    }

    public BookDao(Book book) {
        this.book = book;
    }

    public void addBook(Book book) throws DaoException {

        if (books.contains(book)){
            throw new DaoException("There is a book of this type in the list.");
        }else {
            books.add(book);
        }

    }

    public void addBook(List<Book> books) throws DaoException {
        for (Book book : books) {
            if (books.contains(book)){
                throw new DaoException("There is a book of this type in the list.");
            }else {
                books.add(book);
            }
        }

    }

    public void removeBook(Book book) throws DaoException {
        if (!books.contains(book)){
            throw new DaoException("There is no book of this type in the List.");
        }else {
            books.remove(book);
        }
    }

    public <T> Book findByTag(Field field, T name) {
        SearchSpecificationFactory factory = new SearchSpecificationFactory();
        SearchSpecification specification = factory.create(field);
        return specification.find(books, name);
    }

    public void sortByTag(Field field) {
        SortingSpecificationFactory factory = new SortingSpecificationFactory();
        SortingSpecification specification = factory.create(field);
        specification.sort(books);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Book book : books){
            builder.append(book.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDao bookDao = (BookDao) o;
        return Objects.equals(book, bookDao.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book);
    }
}
