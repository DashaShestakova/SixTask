package com.epam.idea.task.six;

import com.epam.idea.task.six.data.BookCreator;
import com.epam.idea.task.six.data.BookDao;
import com.epam.idea.task.six.exception.DaoException;
import com.epam.idea.task.six.exception.DataException;
import com.epam.idea.task.six.input.FileInput;
import com.epam.idea.task.six.model.Book;
import com.epam.idea.task.six.factory.Field;
import org.apache.log4j.Logger;

import java.util.List;

public class Director {
    public static final Logger LOGGER = Logger.getLogger(Director.class);
    private FileInput file;
    private BookCreator creator;
    private BookDao bookDao;

    public Director(FileInput file, BookCreator creator, BookDao bookDao) {
        this.file = file;
        this.creator = creator;
        this.bookDao = bookDao;
    }

    public void run(){
        try {
            create();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    private void create() throws DataException, DaoException {
        LOGGER.info("Start Director.");
        String text = file.readInput();
        LOGGER.info("Parsing input file.");

        List<Book> inputBooks = creator.createBookList(text);
        bookDao.addBook(inputBooks);
        LOGGER.info("Creating of BookDao.");

        Book book = inputBooks.get(0);
        bookDao.removeBook(book);
        LOGGER.info("Remove one book.");

        Book findedBooks = bookDao.findByTag(Field.AUTHOR, "Lev Tolstoy" );
        LOGGER.info("Find books by field.");
        Director.LOGGER.info(findedBooks.toString());

        bookDao.sortByTag(Field.YEAR);
        LOGGER.info("Sort books by field.");
        Director.LOGGER.info(bookDao.toString());
        LOGGER.info("End of Director.");

    }
}



