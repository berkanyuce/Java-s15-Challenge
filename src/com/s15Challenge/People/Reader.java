package com.s15Challenge.People;

import com.s15Challenge.Book;
import com.s15Challenge.Interfaces.IEvents;
import com.s15Challenge.enums.Statuses;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person implements IEvents {
    private List<Book> books;
    private double balance;
    public Reader (String name) {
        super(name);
        books = new ArrayList<>();
        balance = 1000.0;
    }
    public List<Book> getBooks() {
        return books;
    }

    public void borrow_book(Book book) {
        if(books.size() < 5) {
            if (book.getStatus().equals(Statuses.AVAILABLE)) {
                addBook(book);
                balance -= book.getPrice();
                System.out.println(this.getName() + " has borrowed " + book.get_title() + " book...");
            } else {
                if (book.get_owner().equals(this.getName())) {
                    System.out.println(this.getName() + " already owned this book...");
                } else {
                    System.out.println("The book is owned by " + book.get_owner() + " and can not be borrowed");
                }
            }
        }
        else {
            System.out.println("The reader has been reached the limit of " + books.size() + " books");
        }

    }
    public void return_book(Book book) {
        if(book.get_owner().equals(super.getName())) {
            balance += book.getPrice();
            books.remove(book);
            book.change_owner(null);
            book.updateStatus(Statuses.AVAILABLE);
            System.out.println(book.get_title() + " is taken from " + this.getName());
        }
        else {
            System.out.println("This book is not owned by the reader...");
        }

    }

    public void show_books() {
        System.out.println(getName() + "'s books: ");
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public void addBook(Book book) {
        books.add(book);
        book.change_owner(this);
        book.updateStatus(Statuses.OWNED);
    }

    @Override
    public String toString() {
        return  getName() + "' details {" + "\n" +
                "books=" + books + "\n" +
                ", balance=" + balance + "\n" +
                '}';
    }
}
