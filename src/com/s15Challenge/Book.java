package com.s15Challenge;

import com.s15Challenge.People.Author;
import com.s15Challenge.People.Person;
import com.s15Challenge.enums.Categories;
import com.s15Challenge.enums.Statuses;

public class Book{
    private int book_ID;
    private Author author;
    private String name;
    private double price;
    private Statuses status;
    private Categories category;
    private String date_of_purchase;
    private Person owner;

    public Book(int book_ID, Author author, String name, double price, Statuses status, Categories category, String date_of_purchase) {
        this.book_ID = book_ID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.category = category;
        this.date_of_purchase = date_of_purchase;
    }
    public int getBook_ID(){
        return book_ID;
    }
    public Statuses getStatus() {
        return status;
    }
    public String get_title() {
        return name;
    }
    public Author get_author() {
        return author;
    }
    public String get_owner() {
        return (owner != null) ? owner.getName() : null;
    }
    public Categories get_category() {
        return category;
    }
    public void change_owner(Person newOwner) {
        if(newOwner != null) {
            System.out.println("Book's owner changed to " + newOwner.getName());
            owner = newOwner;
        }
        else {
            System.out.println("Book is taken back.");
            owner = null;
        }
    }
    public void updateStatus(Statuses newStatus) {
        if (owner == null || newStatus.equals(Statuses.OWNED)) {
            System.out.println(this.get_title() + "'s status changed.");
            status = newStatus;
        } else if (status.equals(Statuses.OWNED)) {
            System.out.println(this.get_title() + "'s status changed.");
            status = newStatus;
        } else {
            System.out.println("The book is currently owned and cannot be set to 'Available'.");
        }
    }
    public void updatePrice(double newPrice) {
        System.out.println(this.get_title() + "'s price changed.");
        price = newPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_ID=" + book_ID +
                ", author='" + author.getName() + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status='" + status.toString() + '\'' +
                ", category='" + category.toString() + '\'' +
                ", date_of_purchase='" + date_of_purchase + '\'' +
                ", owner=" + get_owner() +
                '}' + "\n";
    }
}
