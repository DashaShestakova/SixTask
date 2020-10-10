package com.epam.idea.task.six;

import com.epam.idea.task.six.data.BookCreator;
import com.epam.idea.task.six.data.BookDao;
import com.epam.idea.task.six.exception.DaoException;
import com.epam.idea.task.six.exception.DataException;
import com.epam.idea.task.six.input.FileInput;
import com.epam.idea.task.six.model.Book;
import com.epam.idea.task.six.specification.factory.Field;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {
    public static final Logger LOGGER = Logger.getLogger(Main.class);
    public static final String FILE_PATH = "src/main/resources/input.txt";
    public static final Book BOOK_TO_ADD = new Book("War and Peace", "Lev Tolstoy", 1865, 1225, "Russian");

    public static void main(String[] args) {
        try {
            runner();
        } catch (Exception e) {
            LOGGER.error(e);
        }

    }
    private static void runner() throws DataException, DaoException {
        LOGGER.info("Start Main.");
        FileInput file = new FileInput(FILE_PATH);
        String text = file.readInput();
        LOGGER.info("Parsing input file.");

        BookCreator creator = new BookCreator();
        List<Book> inputBooks = creator.createBookList(text);
        BookDao bookDao = new BookDao(inputBooks);
        LOGGER.info("Creating of BookDao.");

        Book book = inputBooks.get(0);
        bookDao.removeBook(book);
        LOGGER.info("Remove one book.");

        bookDao.addBook(BOOK_TO_ADD);
        LOGGER.info("Added one book.");

        Book findedBooks = bookDao.findByTag(Field.AUTHOR, "Lev Tolstoy" );
        LOGGER.info("Find books by field.");
        Main.LOGGER.info(findedBooks.toString());

        bookDao.sortByTag(Field.YEAR);
        LOGGER.info("Sort books by field.");
        Main.LOGGER.info(bookDao.toString());
        LOGGER.info("End of Main.");

    }
}



