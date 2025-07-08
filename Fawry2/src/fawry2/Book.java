/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fawry2;
import java.time.Year;

/**
 *
 * @author ZaRZoR
 */
public abstract  class Book {
    private final String isbn;
    private final String title;
    private final int publishedYear; 
    private final double price; 

    public Book(String isbn, String title, int publishedYear, double price) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be empty.");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        if (publishedYear > Year.now().getValue()) {
            throw new IllegalArgumentException("Published year cannot be in the future.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        this.isbn = isbn;
        this.title = title;
        this.publishedYear = publishedYear;
        this.price = price;
    }

    public String getISBN() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public double getPrice() {
        return price;
    }

    public abstract boolean isForSale();

    public abstract double purchase(int quantity, String email, String address);

    public void displayDetails() {
        System.out.println("--- Book Details ---");
        System.out.println("  ISBN: " + isbn);
        System.out.println("  Title: " + title);
        System.out.println("  Published: " + publishedYear);
        System.out.println("  Price: $" + String.format("%.2f", price));
    }

    @Override
    public String toString() {
        return "'" + title + "' (ISBN: " + isbn + ")";
    }
}
