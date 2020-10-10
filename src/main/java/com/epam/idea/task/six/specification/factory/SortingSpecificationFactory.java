package com.epam.idea.task.six.specification.factory;

import com.epam.idea.task.six.specification.sort.*;

public class SortingSpecificationFactory {
    public SortingSpecification create(Field field) {

        switch (field) {
            case TITLE:
                return new TitleSorting();
            case AUTHOR:
                return new AuthorSorting();
            case YEAR:
                return new YearSorting();
            case NUMBER_OF_PAGES:
                return new NumberOfPagesSorting();
            case LANGUAGE:
                return new LanguageSorting();
            default:
                throw new IllegalArgumentException("There is no such type of field " + field);
        }

    }
}

