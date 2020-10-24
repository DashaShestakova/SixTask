package com.epam.idea.task.six.data;

import com.epam.idea.task.six.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookCreator {
    public static final int FIRST_FIELD = 0;
    public static final int SECOND_FIELD = 1;
    public static final int THIRD_FIELD = 2;
    public static final int FOURTH_FIELD = 3;
    public static final int FIFTH_FIELD = 4;

    public List<Book> createBookList(String input) {

        String[] lines = input.split("\n");

        List<Book> books = new ArrayList();

        for (int i = 0; i < lines.length; i++) {
            Book book = createBook(lines[i]);
            books.add(book);
        }

        return books;
    }

    public Book createBook(String line) {

        String[] fields = line.split(",");

        for(int i = 0; i < fields.length; i++){
            fields[i] = fields[i].trim();
        }

        String title = fields[FIRST_FIELD];
        String author = fields[SECOND_FIELD];
        Integer year = Integer.parseInt(fields[THIRD_FIELD]);
        Integer numberOfPages = Integer.parseInt(fields[FOURTH_FIELD]);
        String language = fields[FIFTH_FIELD];


        return new Book(title, author, year, numberOfPages, language);
    }

}
