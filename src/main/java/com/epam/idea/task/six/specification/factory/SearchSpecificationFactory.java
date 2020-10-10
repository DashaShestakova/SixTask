package com.epam.idea.task.six.specification.factory;

import com.epam.idea.task.six.specification.search.*;

public class SearchSpecificationFactory {

    public SearchSpecification create(Field field) {

        switch (field) {
            case TITLE:
                return new TitleSearch();
            case AUTHOR:
                return new AuthorSearch();
            case YEAR:
                return new YearSearch();
            case NUMBER_OF_PAGES:
                return new NumberOfPagesSearch();
            case LANGUAGE:
                return new LanguageSearch();
            default:
                throw new IllegalArgumentException("There is no such type of field " + field);
        }

    }
}
