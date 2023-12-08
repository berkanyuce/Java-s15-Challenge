package com.s15Challenge;

import com.s15Challenge.People.Author;
import com.s15Challenge.People.Reader;
import com.s15Challenge.enums.Categories;
import com.s15Challenge.enums.Statuses;

public class Main {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library();

        // Create an author
        Author author1 = new Author("John Author");
        Author author2 = new Author("Ahmet Author");

        // Create a reader
        Reader reader1 = new Reader("Alice Reader");
        Reader reader2 = new Reader("Mehmet Reader");

        // Create a book
        Book book1 = new Book(1, author1, "Book1", 29.99, Statuses.AVAILABLE, Categories.ART, "12-10-2023");
        Book book2 = new Book(2, author2, "Book2", 19.99, Statuses.AVAILABLE, Categories.FICTION, "15-10-2023");
        Book book3 = new Book(3, author2, "Book3", 9.99, Statuses.AVAILABLE, Categories.HISTORY, "25-10-2023");
        Book book4 = new Book(4, author1, "Book4", 39.99, Statuses.AVAILABLE, Categories.HISTORY, "15-10-2023");
        Book book5 = new Book(5, author1, "Book5", 49.99, Statuses.AVAILABLE, Categories.ART, "05-11-2023");
        Book book6 = new Book(6, author2, "Book6", 59.99, Statuses.AVAILABLE, Categories.HISTORY, "05-08-2023");

        // Add books to library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);

        System.out.println("************************");

        // Add readers to library
        library.add_reader(reader1);
        library.add_reader(reader2);

        System.out.println("************************");

        // Shows all registered books
        library.show_books();

        System.out.println("************************");

        // Shows registered books by category
        library.show_books(book2.get_category());

        System.out.println("************************");

        // Display books owned by the author
        System.out.println(author1);
        System.out.println(author2);

        System.out.println("************************");


        // Reader borrows a book
        reader1.borrow_book(book1);
        reader1.borrow_book(book2);
        // Reader can not borrow because of limitation

        reader1.borrow_book(book3);
        reader1.borrow_book(book4);
        reader1.borrow_book(book5);
        reader1.borrow_book(book6);
        reader1.show_books();
        System.out.println(reader1);

        reader2.borrow_book(book2); // can not be borrowed because it is already borrowed
        //library.show_books();
        reader2.borrow_book(book3);

        System.out.println("************************");

        // Shows readers' books
        reader1.show_books();
        reader2.show_books();
        //library.show_books();

        System.out.println("************************");

        // Reader returns a book
        reader1.show_books();
        reader1.return_book(book1);
        //library.show_books();

        System.out.println("************************");

        // Library methods
        library.show_books();
        System.out.println("************************");
        library.get_reader(book2.get_title());
        library.lend_book(book1.get_title(), reader2.getName());
        library.lend_book(book1.get_title(), reader1.getName());
        library.take_back_book(book1.get_title());

        System.out.println("************************");

        // Get books by id, title and author's name
        library.show_book(book1.get_author());
        library.show_book(book1.getBook_ID());
        library.show_book(book1.get_title());
        library.show_book(author2);


        System.out.println("************************");

        // Update data of a book
        //library.show_book(2);
        book2.updatePrice(199.99);
        //library.show_book(2);

        System.out.println("************************");

        // Delete book from library
        library.remove_book(book1);
        library.remove_book(book5);


        System.out.println("************************");

        // Changing owner of book
        book3.change_owner(reader2);
        library.get_books();
        reader2.show_books();
        reader1.show_books();

        System.out.println("************************");

    }
}
