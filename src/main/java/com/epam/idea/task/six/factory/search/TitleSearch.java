package com.epam.idea.task.six.factory.search;

import com.epam.idea.task.six.model.Book;

public class TitleSearch extends AbstractSearch{

    @Override
    String getField(Book book) {
        return book.getTitle();
    }

}
