package com.s15Challenge;

import com.s15Challenge.Interfaces.IEvents;
import com.s15Challenge.People.Author;
import com.s15Challenge.People.Reader;
import com.s15Challenge.enums.Categories;
import com.s15Challenge.enums.Statuses;

import java.util.HashMap;
import java.util.Map;

public class Library implements IEvents {
    private Map<String, Book> books;
    private Map<String, Reader> readers;
    private Map<String, Author> authors;

    public Library() {
        this.books = new HashMap<>();
        this.readers = new HashMap<>();
        this.authors = new HashMap<>();
    }

    public Map get_books() {
        return books;
    }

    public void get_reader(String bookName) {
        // Kitabı adına göre bul
        Book book = books.get(bookName);

        if (book != null) {
            // Kitabın sahibini al
            String ownerName = book.get_owner();

            if (ownerName != null) {
                // Kitabın sahibini ekrana yazdır
                System.out.println("Owner of the book '" + bookName + "': " + ownerName);
            } else {
                System.out.println("The book is currently not owned by anyone.");
            }
        } else {
            System.out.println("Book with the name '" + bookName + "' not found.");
        }
    }

    public void addBook(Book book) {
        books.put(book.get_title(), book);
        book.get_author().addBook(book);
        System.out.println(book.get_title() + " added to library");
    }
    public void lend_book(String bookTitle, String readerName) {
        Book book = books.get(bookTitle);
        Reader reader = readers.get(readerName);

        if (book != null && reader != null && book.getStatus().equals(Statuses.AVAILABLE)) {
            reader.borrow_book(book);
            System.out.println(book.get_title() + "' is lent to " + reader.getName());
        } else {
            System.out.println(bookTitle + " is not available for borrowing or the reader is not found.");
        }
    }
    public void take_back_book(String bookTitle) {
        Book book = books.get(bookTitle);
        book.updateStatus(Statuses.AVAILABLE);
        for (Reader reader : readers.values()) {
            if (reader.getBooks().contains(book)) {
                reader.return_book(book);
            }
        }
    }

    public void show_book(String bookTitle) {
        Book book = books.get(bookTitle);
        if (book != null) {
            System.out.println("The details of the book : " + book.toString());
        } else {
            System.out.println(bookTitle + " is not found.");
        }
    }
    public void show_book(Author author) {
        System.out.println(author.toString());
    }
    public void show_book(int bookId) {
        for (Book book : books.values()) {
            if (book.getBook_ID() == bookId) {
                System.out.println("The details of the book : " + book.toString());
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    public void add_reader(Reader reader) {
        readers.put(reader.getName(), reader);
        System.out.println(reader.getName() + " added to library");
    }

    public void remove_book(Book book) {
        if (book.getStatus().equals(Statuses.AVAILABLE)) {
            books.remove(book.get_title());
            System.out.println(book.get_title() + " is removed successfully.");
        }
        else {
            System.out.println("The book is owned by " + book.get_owner() + " and can not be removed");
        }
    }

    public void show_books() {
        System.out.println("Books in the library:");
        for (Book book : books.values()) {
            System.out.println(book.toString());
        }
    }
    public void show_books(Categories category) {
        System.out.println("Books belonging to this category in the library:");
        for (Book book : books.values()) {
            if (book.get_category().equals(category)) {
                System.out.println(book.toString());
            }
        }
    }
}
