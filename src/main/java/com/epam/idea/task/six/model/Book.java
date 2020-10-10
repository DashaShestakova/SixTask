package com.epam.idea.task.six.model;

public class Book {
    private String title;
    private String author;
    private Integer year;
    private Integer numberOfPages;
    private String language;

    public Book(String title, String author, int year, int numberOfPages, String language) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.numberOfPages = numberOfPages;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) &&
                author.equals(book.author) &&
                year.equals(book.year) &&
                numberOfPages.equals(book.numberOfPages) &&
                language.equals(book.language);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((language == null) ? 0 : language.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", numberOfPages=" + numberOfPages +
                ", language='" + language + '\'' +
                '}';
    }
}

