package com.epam.idea.task.six.data;

import com.epam.idea.task.six.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookCreator {


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

        String title = fields[0];
        String author = fields[1];
        Integer year = Integer.parseInt(fields[2]);
        Integer numberOfPages = Integer.parseInt(fields[3]);
        String language = fields[4];


        return new Book(title, author, year, numberOfPages, language);
    }

}
