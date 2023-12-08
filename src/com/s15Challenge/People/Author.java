package com.s15Challenge.People;

import com.s15Challenge.Book;
import com.s15Challenge.Interfaces.IEvents;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person implements IEvents {
    private List<Book> books;

    public Author(String name) {
        super(name);
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return  getName() + "' details {" + "\n" +
                "books=" + books;
    }
}
