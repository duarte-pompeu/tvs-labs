package com.bookstore.domain;

/**
 * Object to hold the search criteria to search books.
 * The search criteria can contain the name of an author or a title.
 */
public class SearchCriteria {

    private String title;
    private String author;

    public SearchCriteria(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof SearchCriteria))
            return false;

        SearchCriteria other = (SearchCriteria)o;
        return author.equals(other.author) && title.equals(other.title);
    }
}
