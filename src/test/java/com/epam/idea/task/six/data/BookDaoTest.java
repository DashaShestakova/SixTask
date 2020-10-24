package com.epam.idea.task.six.data;

import com.epam.idea.task.six.exception.DaoException;
import com.epam.idea.task.six.model.Book;
import com.epam.idea.task.six.factory.Field;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BookDaoTest {

    public static final Book FIRST_BOOK = new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866, 672, "Russian");
    public static final Book SECOND_BOOK = new Book("The Count of Monte Cristo", "Alexander Duma", 1844, 1350, "French");
    public static final Book THIRD_BOOK = new Book("The Call of the Wild", "Jack London", 1903, 232,  "English");
    public static final Book FOURTH_BOOK = new Book("War and Peace", "Lev Tolstoy", 1865, 1225, "Russian");
    public static final String AUTHOR = "Fyodor Dostoevsky";
    public static final List<Book> BOOK_DAO_LIST = Arrays.asList(FIRST_BOOK, SECOND_BOOK, THIRD_BOOK);
    public static final List<Book> EXPECTED_SORTED_BOOKDAO = Arrays.asList(SECOND_BOOK, FIRST_BOOK, THIRD_BOOK);

    @Test
    public void testAddShouldAddBook() throws DaoException{
        BookDao bookDao = new BookDao();
        int startSize = bookDao.size();

        bookDao.addBook(FIRST_BOOK);
        int finalSize = bookDao.size();

        Assert.assertEquals(startSize + 1, finalSize);
    }

    @Test
    public void testRemoveShouldRemoveBook() throws DaoException{
        BookDao bookDao = new BookDao();
        bookDao.addBook(BOOK_DAO_LIST);
        int startSize = bookDao.size();

        bookDao.removeBook(FIRST_BOOK);

        int finalSize = bookDao.size();
        Assert.assertEquals(startSize, finalSize + 1);
    }

    @Test
    public void testSortByTagShouldSortBooksWhenFieldIsAuthor() throws DaoException {
        BookDao bookDao = new BookDao();
        bookDao.addBook(BOOK_DAO_LIST);
        List<Book> sortedBooks = bookDao.sortByTag(Field.YEAR);

        Assert.assertEquals(sortedBooks, EXPECTED_SORTED_BOOKDAO);
    }

    @Test
    public void testFindByTagShouldFindBookWhenFieldIsAuthor() throws DaoException {
        BookDao bookDao = new BookDao();
        bookDao.addBook(BOOK_DAO_LIST);
        Book findedBook = bookDao.findByTag(Field.AUTHOR, AUTHOR);

        Assert.assertEquals(findedBook, FIRST_BOOK);
    }
}
