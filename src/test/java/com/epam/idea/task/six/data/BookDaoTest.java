package com.epam.idea.task.six.data;

import com.epam.idea.task.six.exception.DaoException;
import com.epam.idea.task.six.exception.DataException;
import com.epam.idea.task.six.input.FileInput;
import com.epam.idea.task.six.model.Book;
import com.epam.idea.task.six.specification.factory.Field;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BookDaoTest {
    public static final String TEST_FILE_PATH = "src/test/resources/inputTest.txt";

    public static final Book EXPECTED_BOOK = new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866, 672, "Russian");
    public static final String AUTHOR = "Fyodor Dostoevsky";
    public static final BookDao EXPECTED_SORTED_BOOKDAO = new BookDao(Arrays.asList(
            new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866, 672, "Russian"),
            new Book("The Call of the Wild", "Jack London", 1903, 232,  "English"),
            new Book("The Count of Monte Cristo", "Alexander Duma", 1844, 1350, "French")));
    public static final Book BOOK_TO_ADD = new Book("War and Peace", "Lev Tolstoy", 1865, 1225, "Russian");
    public static final BookDao EXPECTED_BOOKDAO_WITH_ADDED_BOOK = new BookDao(Arrays.asList(
            new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866, 672, "Russian"),
            new Book("The Count of Monte Cristo", "Alexander Duma", 1844, 1350, "French"),
            new Book("The Call of the Wild", "Jack London", 1903, 232,  "English"),
            new Book("War and Peace", "Lev Tolstoy", 1865, 1225, "Russian")));
    public static final Book BOOK_TO_REMOVE = new Book("The Call of the Wild", "Jack London", 1903, 232,  "English");
    public static final BookDao EXPECTED_BOOKDAO_AFTER_BOOK_REMOVE = new BookDao(Arrays.asList(
            new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866, 672, "Russian"),
            new Book("The Count of Monte Cristo", "Alexander Duma", 1844, 1350, "French"),
            new Book("The Call of the Wild", "Jack London", 1903, 232,  "English")));
    @Test
    public void testAddShouldAddBook() throws DaoException, DataException {
        BookDao bookDao = createBookDao();

        bookDao.addBook(BOOK_TO_ADD);

        Assert.assertEquals(bookDao, EXPECTED_BOOKDAO_WITH_ADDED_BOOK);
    }

    @Test
    public void testRemoveShouldRemoveBook() throws DaoException, DataException {
        BookDao bookDao = createBookDao();

        bookDao.removeBook(BOOK_TO_REMOVE);

        Assert.assertEquals(bookDao, EXPECTED_BOOKDAO_AFTER_BOOK_REMOVE);
    }

    @Test
    public void testSortByTagShouldSortBooksWhenFieldIsAuthor() throws DataException {
        BookDao bookDao = createBookDao();

        bookDao.sortByTag(Field.AUTHOR);

        Assert.assertEquals(bookDao, EXPECTED_SORTED_BOOKDAO);
    }

    @Test
    public void testFindByTagShouldFindBookWhenFieldIsAuthor() throws DataException {
        BookDao bookDao = createBookDao();

        BookDao findedBookDao = new BookDao(bookDao.findByTag(Field.AUTHOR, AUTHOR));

        BookDao expectedBookDao = new BookDao(EXPECTED_BOOK);

        Assert.assertEquals(findedBookDao, expectedBookDao);
    }
